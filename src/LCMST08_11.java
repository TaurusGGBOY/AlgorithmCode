class Solution {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] num = {25, 10, 5, 1};
        for (int j = 0; j < 4; j++) {
            int coin = num[j];
            for (int i = coin; i < n + 1; i++) {
                dp[i] += dp[i - coin];
                dp[i] %= 1000000007;

            }
        }
        return dp[n];
    }
}