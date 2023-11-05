class Solution {
    public int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (left[i - 1] < nums[i] && nums[i] > right[i + 1]) {
                res = Math.min(left[i - 1] + nums[i] + right[i + 1], res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}