package info.jiaying.log_transfer_hub.logparser;

import info.jiaying.log_transfer_hub.logparser.domainknowledge.DomainKnowledgeManager;
import info.jiaying.log_transfer_hub.logparser.domainknowledge.impl.TimeRelatedKnowledge;
import info.jiaying.log_transfer_hub.logparser.tree.router.LengthRouter;
import info.jiaying.log_transfer_hub.logparser.tree.router.WordRouter;
import lombok.Data;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.function.Function;

/**
 * This class contains the parsing logic for implementing the DRAIN algorithm.
 * See original paper: <a href="http://jmzhu.logpai.com/pub/pjhe_icws2017.pdf">link to paper</a>
 */
public class DrainLogParser {
    private final int MAX_DEPTH;
    private final int MAX_CHILDREN;
    private final float SIMILARITY_THRESHOLD;
    private static final String WILD_CARD = "<*>";
    private static int count = 0;

    private final String ROUTER_PACKAGE_PATH = "info.jiaying.log_transfer_hub.logparser.tree.router.";

    private final DomainKnowledgeManager domainKnowledge = new DomainKnowledgeManager();

    private final Node root;

    private final RouterType[] routerTypeConf;

    public enum RouterType {
        LengthRouter,
        WordRouter
    }

    public static void main(String[] args) {
        DrainLogParser parser = new DrainLogParser(10, 10, 0.85F);
        System.out.println(parser.parseLogLine("Dec  3 03:12:01 VM-4-2-centos kernel: device eth0 left promiscuous mode"));
        System.out.println(parser.parseLogLine("Dec  3 03:12:01 VM-4-2-centos systemd: Started Session 316064 of user root"));
        System.out.println(parser.parseLogLine("Feb 17 03:07:40 VM-4-2-centos sshd[8547]: pam_unix(sshd:auth): check pass; user unknown"));
        System.out.println(parser.parseLogLine("Feb 17 03:11:00 VM-4-2-centos sshd[9505]: pam_unix(sshd:auth): check pass; user unknown"));
    }

    public DrainLogParser(int maxDepth, int maxChildren, float similarityThreshold) {
        MAX_DEPTH = maxDepth;
        MAX_CHILDREN = maxChildren;
        SIMILARITY_THRESHOLD = similarityThreshold;
        domainKnowledge.register(new TimeRelatedKnowledge());
        routerTypeConf = new RouterType[maxDepth];
        routerTypeConf[0] = RouterType.LengthRouter;
        for (int i = 1; i < maxDepth; i++) {
            routerTypeConf[i] = RouterType.WordRouter;
        }
        root = new Node(0, getRouterByType(routerTypeConf[0]));
    }

    public Function<String[], Integer> getRouterByType(RouterType type, Object... params) {
        try {
            Class<?> clazz = Class.forName(ROUTER_PACKAGE_PATH + type.name());
            if (type == RouterType.WordRouter) {
                Constructor<?> constructor = clazz.getConstructor(int.class);
                return (WordRouter) constructor.newInstance((int) params[0]);
            } else if (type == RouterType.LengthRouter) {
                return (LengthRouter) clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null; // 不理解为什么这里要加上return
    }

    String[] preprocess(final String logLine) {
        String[] tokens = logLine.strip().split(" +");
        String[] filteredTokens = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            filteredTokens[i] = domainKnowledge.isIdentified(tokens[i]) ? WILD_CARD : tokens[i];
        }
        return filteredTokens;
    }

    public int parseLogLine(final String logLine) {
        String[] logTokens = preprocess(logLine);
        Node crtNode = root;
        while (crtNode.next(logTokens) != null) {
            crtNode = crtNode.next(logTokens);
        }
        return crtNode.getEventId(logTokens);
    }

    @Data
    public class Node {
        private int height;
        private Map<Integer, Node> children = new HashMap<>();
        private Function<String[], Integer> router;
        private LogGroupManager logGroupManager;

        Node(int height, Function<String[], Integer> router) {
            this.height = height;
            this.router = router;
        }

        public Node next(String[] tokens) {
            if (height >= MAX_DEPTH - 1) {
                return null;
            }

            Integer idx = router.apply(tokens);
            // Negative index means a leaf node
            if (idx < 0) {
                return null;
            }

            // If idx exceeds the max children which means there is no enough node for this new feature
            // , defaults to direct to the last node.
            if (idx >= MAX_CHILDREN) {
                return children.get(MAX_CHILDREN - 1);
            }

            if (!children.containsKey(idx)) {
                // Create new node for the new feature
                children.put(idx, new Node(height + 1, getRouterByType(routerTypeConf[height + 1], height + 1)));
            }

            return children.get(idx);
        }

        public int getEventId(String[] tokens) {
            if (logGroupManager == null) {
                logGroupManager = new LogGroupManager();
            }
            return logGroupManager.put(tokens);
        }
    }

    public class LogGroupManager {
        private final List<LogGroup> logGroups = new ArrayList<>();

        public int put(String[] tokens) {
            float local_max_threshold = 0F;
            LogGroup matchedLogGroup = null;
            for (LogGroup logGroup : logGroups) {
                float currentSimilarity = logGroup.doCalculateSimilarity(tokens);
                if (currentSimilarity >= SIMILARITY_THRESHOLD && currentSimilarity >= local_max_threshold) {
                    local_max_threshold = currentSimilarity;
                    matchedLogGroup = logGroup;
                }
            }
            if (matchedLogGroup == null) {
                logGroups.add(new LogGroup(count++, tokens));
                matchedLogGroup = logGroups.get(logGroups.size() - 1);
            }
            return matchedLogGroup.getEventId();
        }
    }

    @Data
    public static class LogGroup {
        private int eventId;
        private String[] logEvent;

        LogGroup(int eventId, String[] logTokens) {
            this.eventId = eventId;
            this.logEvent = logTokens;
        }

        /**
         * We calculate how close the given logEvent is to the stored logEvent pattern.
         * <p>
         * {@code "<*>"} indicates that the template has a wildcard match. But, if we also want to
         * return how "exact" a match is. Meaning, we consider exact matches (not from wildcards) to have a higher priority.
         *
         * @param logEvent The previously parsed logEvent to calculate
         * @return A AbstractMap.SimpleEntry of the Similarity and how many exact token matches there were
         */

        float doCalculateSimilarity(String[] logEvent) {
//            int eqSum = 0;
            int exactness = 0;
            for (int i = 0; i < logEvent.length && i < this.logEvent.length; i++) {
                if (logEvent[i].equals(this.logEvent[i])) {
                    exactness++;
//                    eqSum++;
                }
//                else if (this.logEvent[i].equals(WILD_CARD)) {
//                    eqSum++;
//                }
            }
            return logEvent.length < this.logEvent.length? (float) exactness / logEvent.length: (float) exactness / this.logEvent.length;
        }

    }
}