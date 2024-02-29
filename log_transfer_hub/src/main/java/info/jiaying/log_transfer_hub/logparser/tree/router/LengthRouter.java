package info.jiaying.log_transfer_hub.logparser.tree.router;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LengthRouter implements Function<String[], Integer> {
    private Integer allocatePtr = 0;
    Map<Integer, Integer> hashmap = new HashMap<>();

    @Override
    public Integer apply(String[] tokens) {
        int length = tokens.length;
        if (hashmap.containsKey(length)) {
            return hashmap.get(length);
        } else {
            hashmap.put(length, allocatePtr++);
            return hashmap.get(length);
        }
    }
}

