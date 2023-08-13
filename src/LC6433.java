class Solution {
    public int maxMoves(int[][] grid) {
        // 右上 右 右下

        int res = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int j = grid[0].length - 2; j >= 0; j--) {
            for (int i = 0; i < grid.length; i++) {
                if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j + 1] + 1, dp[i][j]);
                }

                if (grid[i][j] < grid[i][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j + 1] + 1, dp[i][j]);
                }

                if (i < grid.length - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i + 1][j + 1] + 1, dp[i][j]);
                }
                if (j == 0) res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}