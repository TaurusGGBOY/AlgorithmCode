import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] o : operations) {
            int index = map.get(o[0]);
            map.remove(o[0]);
            nums[index] = o[1];
            map.put(o[1], index);
        }
        return nums;
    }
}