class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, 0, target);
    }

    int find(int[] nums, int start, int target) {
        if (start == nums.length) return target == 0 ? 1 : 0;
        int l = find(nums, start + 1, target + nums[start]);
        int r = find(nums, start + 1, target - nums[start]);
        return l + r;
    }
}