class Solution {
    public int maximumDifference(int[] nums) {
        int res = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(nums[i] - min, res);
            min = Math.min(nums[i], min);
        }
        return res == 0 ? -1 : res;
    }
}