class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(nums, m, k)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (l == nums.length && !check(nums, r, k)) return -1;
        return l;
    }

    boolean check(int[] nums, int w, int k) {
        int sum = 0;
        for (int i = 0; i < w; i++) sum += nums[i];
        if (sum >= k) return true;
        for (int i = w; i < nums.length; i++) {
            sum -= nums[i - w];
            sum += nums[i];
            if (sum >= k) return true;
        }
        return false;
    }
}