class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int count = 1;
        int max = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                count++;
                max = Math.max(count, max);

            } else {
                count = 1;

            }
            pre = nums[i];
        }
        return max;
    }
}