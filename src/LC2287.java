import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> counter1 = new HashMap<>();
        Map<Character, Integer> counter2 = new HashMap<>();

        for (char c : s.toCharArray()){
            counter1.merge(c, 1, Integer::sum);
        }

        for (char c : target.toCharArray()){
            counter2.merge(c, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> e : counter2.entrySet()){
            res = Math.max(res, counter1.getOrDefault(e.getKey(), 0) % e.getValue());
        }
        return res;
    }
}