import java.util.HashMap;
import java.util.Map;

class LC {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            map1.merge(words1[i], 1, Integer::sum);
        }

        for (int i = 0; i < words2.length; i++) {
            map2.merge(words2[i], 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) {
                res++;
            }
        }
        return res;
    }
}