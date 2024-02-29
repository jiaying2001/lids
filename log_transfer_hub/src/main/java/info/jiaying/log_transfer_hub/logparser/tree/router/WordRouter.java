package info.jiaying.log_transfer_hub.logparser.tree.router;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class WordRouter implements Function<String[], Integer> {
    private Integer allocatePtr = 0;
    private final Map<String, Integer> hashmap = new HashMap<>();

    private final int layer;

    public WordRouter(int layer) {
        this.layer = layer;
    }

    @Override
    public Integer apply(String[] tokens) {
        if (layer >= tokens.length) {
            return -1; //
        }
        String word = tokens[layer];
        if ("*".equals(word)) {
            return Integer.MAX_VALUE;
        }
        if (!hashmap.containsKey(word)) {
            hashmap.put(word, allocatePtr++);
        }
        return hashmap.get(word);
    }
}