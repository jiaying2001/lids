package info.jiaying.utils.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    static Pattern pidPattern = Pattern.compile("\\[(\\d+)]");
    public static int RFC5424ParsePid(String log) {
        Matcher matcher = pidPattern.matcher(log);
        // Find and print all matches
        if (matcher.find()) {
            String digits = matcher.group(1);
            return Integer.parseInt(digits);
        }
        return -1;
    }
}
