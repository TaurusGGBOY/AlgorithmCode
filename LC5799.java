import java.util.HashMap;
import java.util.Map;

class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> map = new HashMap<>();
        // change to bit operation
        int alpha = 0;
        char[] chars = word.toCharArray();
        long res = 0;
        map.put(alpha, 1);
        // 10^5
        for (int i = 0; i < chars.length; i++) {
            int dis = chars[i] - 'a';
            alpha ^= 1 << dis;
            res += map.getOrDefault(alpha, 0);
            map.merge(alpha, 1, Integer::sum);

            // 10
            for (int j = 0; j < 10; j++) {
                alpha ^= 1 << j;
                res += map.getOrDefault(alpha, 0);
                alpha ^= 1 << j;
            }

        }
        return res;
    }
}