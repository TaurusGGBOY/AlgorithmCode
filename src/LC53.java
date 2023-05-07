class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
                max = Math.max(sum, max);
            }else{
                sum += nums[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}