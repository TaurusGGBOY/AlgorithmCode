class Solution {
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int temp = max - min - 2 * k;
        return Math.max(0, temp);
    }
}