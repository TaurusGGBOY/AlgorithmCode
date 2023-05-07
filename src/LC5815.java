class Solution {
    public long maxPoints(int[][] points) {
        long[][] dp = new long[points.length][points[0].length];

        long res = 0;
        // dp[i][j] = max(dp[i-1][k]-abs(j-k))
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = points[0][i];
            res = Math.max(res, dp[0][i]);
        }

        // 剪枝
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                long max = 0;
                for (int k = 0; k < dp[0].length; k++) {
                    max = Math.max(dp[i - 1][k] - Math.abs(j - k), max);
                }
                dp[i][j] = max + points[i][j];
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}