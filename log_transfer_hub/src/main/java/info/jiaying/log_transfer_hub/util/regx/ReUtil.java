package info.jiaying.log_transfer_hub.util.regx;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReUtil {
    public static boolean isMatch(String str, List<Pattern> patterns) {
        for (Pattern pattern: patterns) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
