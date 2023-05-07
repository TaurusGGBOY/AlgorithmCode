import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] property : properties) {
            int value = map.getOrDefault(property[0], 0);
            map.put(property[0], Math.max(value, property[1]));
        }

        int temp = 0;
        for (int i = 100001; i >= 1; i--) {
            if (map.containsKey(i)) {
                int value = map.get(i);
                if (value > temp) {
                    temp = value;
                }
            }
            map.put(i, temp);
        }
        int res = 0;
        for (int[] property : properties) {
            int value = map.getOrDefault(property[0]+1, 0);
            if (property[1] < value) {
                res++;
            }
        }
        return res;
    }
}