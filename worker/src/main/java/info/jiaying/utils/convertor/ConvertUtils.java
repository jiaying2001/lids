package info.jiaying.utils.convertor;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtils {
    public static byte[] convertToBytes(List<Integer> list) {
        String joinedString = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        return joinedString.getBytes();
    }
}
