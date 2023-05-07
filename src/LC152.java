class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int ax = max, in = min;
            max = Math.max(ax * nums[i], Math.max(in * nums[i], nums[i]));
            min = Math.min(in * nums[i], Math.min(ax * nums[i], nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}