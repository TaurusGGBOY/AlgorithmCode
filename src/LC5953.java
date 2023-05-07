class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long max = nums[i];
            long min = nums[i];
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}