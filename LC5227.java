class Solution {
    public int maximumTop(int[] nums, int k) {
        if (k == 0) return nums[0];
        if (nums.length == 1 && k % 2 == 1) return -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < Math.min(nums.length, k - 1); i++) {
            max = Math.max(nums[i], max);
        }
        if (k >= nums.length) return max;
        return Math.max(max, nums[k]);
    }
}