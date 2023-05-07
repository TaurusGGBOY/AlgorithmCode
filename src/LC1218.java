import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            map.put(value, map.getOrDefault(value - difference, 0) + 1);
        }
        return map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}