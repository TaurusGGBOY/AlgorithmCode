import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue() / 2;
        }
        return new int[]{count, nums.length - count * 2};
    }
}