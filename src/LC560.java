import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            res += sum == k ? 1 : 0;
            res += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return res;
    }
}