package info.jiaying.log_transfer_hub.logparser;

import lombok.Data;

import java.util.*;
import java.util.regex.Pattern;

/**
 * This class contains the parsing logic for implementing the DRAIN algorithm.
 *
 * See original paper: http://jmzhu.logpai.com/pub/pjhe_icws2017.pdf
 */
public class DrainLogParser {

    private static final String WILD_CARD = "<*>";
    private static final Pattern numberPattern = Pattern.compile("\\d+");

    private static int count = 0;

    private final List<Pattern> preProcessPatterns;
    private final int maxDepth;
    private final int maxChildren;
    private final double similarityThreshold;
    private final Map<Integer, TreeNode> root;

    public DrainLogParser(List<Pattern> preProcessPatterns, int maxDepth, int maxChildren, double similarityThreshold) {
        this.preProcessPatterns = Collections.unmodifiableList(preProcessPatterns);
        this.maxDepth = maxDepth;
        this.maxChildren = maxChildren;
        this.similarityThreshold = similarityThreshold;
        this.root = new HashMap<>();
    }

    String[] preprocess(final String logLine) {
        String[] tokens = logLine.strip().split(" ");
        String[] filteredTokens = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            filteredTokens[i] = matchesPattern(tokens[i]) ? WILD_CARD : tokens[i];
        }
        return filteredTokens;
    }

    public LogGroup parseLogLine(final String logLine, final String logId) {
        String[] logTokens = preprocess(logLine);
        int intermediateNodes = maxDepth - 1;
        TreeNode currentNode = this.root.get(logTokens.length);
        for (int i = 0; i < logTokens.length && i < intermediateNodes && currentNode != null; i++) {
            String token = containsNumbers(logTokens[i]) ? WILD_CARD : logTokens[i];
            TreeNode child = currentNode.getChild(token);
            if (child == null && !token.equals(WILD_CARD)) {
                child = currentNode.getChild(WILD_CARD);
            }
            currentNode = child;
        }
        LogGroup foundLogGroup = null;
        if (currentNode != null) {
            // Get the best log group in the current node.
            // If we find one that means that it passes the similarity threshold and is updated to account
            // for the new log message
            foundLogGroup = currentNode.getAndUpdateLogGroup(logTokens, logId);
        }
        // Need to update the tree if possible
        if (foundLogGroup == null) {
            foundLogGroup = addToTree(logTokens, logId);
        }
        return foundLogGroup;
    }

    public LogGroup addToTree(String[] parsedLogTokens, final String logId) {
        TreeNode currentNode = this.root.get(parsedLogTokens.length);
        if (currentNode == null) { // we are missing an entire sub tree. New log length found
            if (this.root.size() > maxChildren) {
                throw new IllegalArgumentException("Maximum number of children reached. Consider adjusting [max_children] or [similarity_threshold] params");
            }
            currentNode = new TreeNode(null, this.maxChildren, this.similarityThreshold);
            this.root.put(parsedLogTokens.length, currentNode);
        }
        for (int i = 0; i < parsedLogTokens.length && i < maxDepth - 1; i++) {
            String currentToken = containsNumbers(parsedLogTokens[i]) ? WILD_CARD : parsedLogTokens[i];
            TreeNode child = currentNode.getChild(currentToken);
            // We are missing a child node for the current token
            if (child == null) {
                child = new TreeNode(currentToken, maxChildren, similarityThreshold);
                if(!currentNode.addChild(currentToken, child)) {
                    throw new IllegalArgumentException("Maximum number of children reached. Consider adjusting [max_children] or [similarity_threshold] params");
                }
            }
            currentNode = child;
        }
        LogGroup group = new LogGroup(count++, parsedLogTokens, logId);
        currentNode.putNewLogGroup(group);
        return group;
    }

    private boolean matchesPattern(final String token) {
        return preProcessPatterns.stream().anyMatch(pattern -> pattern.matcher(token).matches());
    }

    private static boolean containsNumbers(String token) {
        return numberPattern.matcher(token).find();
    }

    public static class TreeNode {

        private final Map<String, TreeNode> children;
        private final int maxChildren;
        private final double similarityThreshold;
        private final String matchToken;
        private final List<LogGroup> logGroups;

        TreeNode(String matchToken, int maxChildren, double similarityThreshold) {
            children = new HashMap<>();
            this.maxChildren = maxChildren;
            this.logGroups = new ArrayList<>();
            this.similarityThreshold = similarityThreshold;
            this.matchToken = matchToken;
        }

        String getMatchToken() {
            return matchToken;
        }

        boolean canAddChild() {
            return this.children.size() <= maxChildren;
        }

        boolean addChild(String token, TreeNode node) {
            if (children.size() >= maxChildren) {
                return false;
            }
            children.put(token, node);
            return true;
        }

        TreeNode getChild(String token) {
            return children.get(token);
        }

        LogGroup getAndUpdateLogGroup(String[] logTokens, String logId) {
            AbstractMap.SimpleEntry<LogGroup, Double> bestGroupAndSimilarity = getBestLogGroup(logTokens);
            if (bestGroupAndSimilarity == null) {
                return null;
            }
            if (bestGroupAndSimilarity.getValue() >= similarityThreshold) {
                bestGroupAndSimilarity.getKey().addLog(logTokens, logId);
                return bestGroupAndSimilarity.getKey();
            }
            return null;
        }

        void putNewLogGroup(LogGroup group) {
            logGroups.add(group);
        }

        private AbstractMap.SimpleEntry<LogGroup, Double> getBestLogGroup(String[] logTokens) {
            if (logGroups.isEmpty()) {
                return null;
            }
            if (logGroups.size() == 1) {
                return new AbstractMap.SimpleEntry<>(logGroups.get(0), logGroups.get(0).calculateSimilarity(logTokens).getKey());
            }
            double maxSimilarity = 0.0;
            int maxExactness = 0;
            LogGroup bestGroup = null;
            for(LogGroup logGroup : this.logGroups) {
                AbstractMap.SimpleEntry<Double, Integer> groupSimilarity = logGroup.calculateSimilarity(logTokens);
                if (groupSimilarity.getKey() > maxSimilarity) {
                    maxSimilarity = groupSimilarity.getKey();
                    maxExactness = groupSimilarity.getValue();
                    bestGroup = logGroup;
                } else if (groupSimilarity.getKey() == maxSimilarity && groupSimilarity.getValue() > maxExactness) {
                    maxExactness = groupSimilarity.getValue();
                }
            }
            return new AbstractMap.SimpleEntry<>(bestGroup, maxSimilarity);
        }
    }

    @Data
    public static class LogGroup {
        private  int eventId;
        private String[] logEvent;
        private final List<String> logIds = new ArrayList<>(1);

        LogGroup(int eventId, String[] logTokens, String logId) {
            this.eventId = eventId;
            this.logEvent = logTokens;
            this.logIds.add(logId);
        }

        public String getLogEvent() {
            StringBuilder stringBuilder = new StringBuilder(logEvent.length + logEvent.length - 1);
            for (String token : logEvent) {
                stringBuilder.append(token).append(" ");
            }
            return stringBuilder.toString();
        }

        public List<String> getLogIds() {
            return Collections.unmodifiableList(logIds);
        }

        /**
         * We calculate how close the given logEvent is to the stored logEvent pattern.
         *
         * {@code "<*>"} indicates that the template has a wildcard match. But, if we also want to
         * return how "exact" a match is. Meaning, we consider exact matches (not from wildcards) to have a higher priority.
         * @param logEvent The previously parsed logEvent to calculate
         * @return A AbstractMap.SimpleEntry of the Similarity and how many exact token matches there were
         */
        AbstractMap.SimpleEntry<Double, Integer> calculateSimilarity(String[] logEvent) {
            assert logEvent.length == this.logEvent.length;
            int eqSum = 0;
            int exactness = 0;
            for (int i = 0; i < logEvent.length; i++) {
                if (logEvent[i].equals(this.logEvent[i])) {
                    exactness++;
                    eqSum++;
                }
                else if (this.logEvent[i].equals(WILD_CARD)) {
                    eqSum++;
                }
            }
            return new AbstractMap.SimpleEntry<>((double)eqSum/logEvent.length, exactness);
        }

        /**
         * See: F. Step 5: Update Parse Tree
         * This mutates the underlying log event so that unmatched tokens are adjusted to be wild cards (i.e. '<*>')
         *
         * @param logEvent event to add to the log group, this will update the stored pattern
         * @param logId the id of the log to add
         */
        void addLog(String[] logEvent, String logId) {
            assert logEvent.length == this.logEvent.length;
            for (int i = 0; i < logEvent.length; i++) {
                if (!logEvent[i].equals(this.logEvent[i])) {
                    this.logEvent[i] = WILD_CARD;
                }
            }
            this.logIds.add(logId);
        }
    }
}