class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] + nums[r] < target) l++;
            while (l < r && nums[l] + nums[r] > target) r--;
            if (l == r) break;
            if (nums[l] + nums[r] == target) return new int[]{nums[l], nums[r]};
        }
        return new int[2];
    }
}
