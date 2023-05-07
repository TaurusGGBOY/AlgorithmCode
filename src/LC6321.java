import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.merge(((nums[i] % value) + value) % value, 1, Integer::sum);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!counter.containsKey(i % value)) return i;
            if (counter.get(i % value) > 1) {
                counter.put(i % value, counter.get(i % value) - 1);
            } else {
                counter.remove(i % value);
            }
        }
        return nums.length;
    }
}