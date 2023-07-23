class Solution {
    public long maxArrayValue(int[] nums) {
        long res = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > res) {
                res = nums[i];
            } else {
                res += nums[i];
            }
        }
        return res;
    }
}