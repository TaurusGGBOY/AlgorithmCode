class Solution {
    public int numWays(int n) {
        int[] dp = new int[n + 5];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i + 1] = (dp[i + 1] + dp[i]) % 1000000007;
            dp[i + 2] = (dp[i + 2] + dp[i]) % 1000000007;
        }
        return dp[n];
    }
}