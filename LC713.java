class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int l = 0, r = 1, count = 0;
        long p = nums[0];
        while (r <= nums.length) {
            while (l < r && p >= k) p /= nums[l++];
            count += r - l;
            if (r == nums.length) break;
            p *= nums[r++];
        }
        return count;
    }
}