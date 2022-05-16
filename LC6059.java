class Solution {

    public boolean hasValidPath(char[][] grid) {
        if (grid[0][0] == ')') return false;
        if ((grid.length + grid[0].length) % 2 == 0) return false;
        int m = grid.length, n = grid[0].length, len = (m + n + 1) / 2;
        int[][][] dp = new int[m][n][len];
        dp[0][0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = grid[i][j] == '(' ? 1 : -1;
                for (int k = 0; k < len; k++) {
                    if (k + left < 0 || k + left >= len) continue;
                    if (i > 0) dp[i][j][k + left] = dp[i][j][k + left] | dp[i - 1][j][k];
                    if (j > 0) dp[i][j][k + left] = dp[i][j][k + left] | dp[i][j - 1][k];
                }
            }
        }
        return dp[m - 1][n - 1][0] == 1;
    }
}