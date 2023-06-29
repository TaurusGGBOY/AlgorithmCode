import java.util.Arrays;

class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Math.abs(nums[1] - nums[0]);
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.min(nums[i + 1] - nums[i], res);
        }
        return res;
    }
}