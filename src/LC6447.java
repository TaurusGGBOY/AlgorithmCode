class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];

        for (int i = 1; i < n; i++) {
            int costPaid = cost[i] + dp[i - 1];
            int costFree = cost[i] * time[i - 1] + dp[i - 1];
            dp[i] = Math.min(costPaid, costFree);
        }

        return dp[n - 1];
    }
}