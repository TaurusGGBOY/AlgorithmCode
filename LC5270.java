class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int num = grid[i][j];
                for (int k = 0; k < grid[0].length; k++) {
                    if (dp[i + 1][k] == 0) dp[i + 1][k] = dp[i][j] + moveCost[num][k] + grid[i + 1][k];
                    else dp[i + 1][k] = Math.min(dp[i][j] + moveCost[num][k] + grid[i + 1][k], dp[i + 1][k]);
                }
            }
        }
        int res = dp[grid.length - 1][0];
        for (int i = 1; i < grid[0].length; i++) {
            res = Math.min(dp[grid.length - 1][i], res);
        }
        return res;
    }
}