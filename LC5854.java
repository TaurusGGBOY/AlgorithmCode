import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = k - 1;
        int res = Integer.MAX_VALUE;
        for (; right < nums.length; right++, left++) {
            res = Math.min(res, nums[right] - nums[left]);
        }
        return res;
    }
}