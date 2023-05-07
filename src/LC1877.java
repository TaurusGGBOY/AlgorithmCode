import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        for (int i = 0; i < nums.length/2; i++) {
            max = Math.max(nums[i] + nums[nums.length - i - 1],max);
        }
        return max;
    }
}