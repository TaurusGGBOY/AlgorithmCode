class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 1;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
            while (sum >= target && l < r) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
            sum += nums[r++];
        }
        while (sum >= target && l < r) {
            res = Math.min(res, r - l);
            sum -= nums[l++];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}