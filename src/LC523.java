import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remind = sum % k;
            if (map.containsKey(remind)) {
                int left = map.get(remind);
                if (i - left >= 2) {
                    return true;
                }
            } else {
                map.put(remind, i);
            }
        }
        return false;
    }
}