import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        // dp[i] 以nums[i] 为结尾的最长递增子序列长度 比较每一个nums[j]
        // count[i] 以nums[i] 为结尾的最长递增子序列的个数
        // dp[i] = max(dp[j]) + 1 if nums[i]>nums[j]
        //
        // dp[i][j] = dp[i][j-2]
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i]+=count[j];
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                ans = count[i];
            } else if (dp[i] == max) {
                ans += count[i];
            }
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(count));
        return ans;
        // 12347 12357 12457
        // 123 123 123 11 12
        // 123 123 11 22
        // 123 11 32
        // 123 123 21 22
        // 123 21 32
        // 123 31 32

    }
}