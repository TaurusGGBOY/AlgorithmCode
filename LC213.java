import java.util.logging.Level;

class Solution {
    public int rob(int[] nums) {
        // dp[i] = math.max(dp[i-2],dp[i-3])
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        // 只有一个例外 就是最后一个和第一个不能同时选
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];

        dp1[1] = Math.max(nums[0], nums[1]);
        dp1[2] = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        dp1[nums.length - 1] = dp1[nums.length - 2];

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);

    }
}