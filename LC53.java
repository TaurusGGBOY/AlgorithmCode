class Solution {
    public int maxSubArray(int[] nums) {
        int i;
        int maxv = nums[0];
        int sum = 0;
        int numsSize = nums.length;
        for (i = 0; i < numsSize; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum = nums[i] + sum;
            }
            if (sum > maxv) {
                maxv = sum;
            }
        }
        return maxv;
    }
}