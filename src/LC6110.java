class Solution {
    static final long mod = 1000000007;

    public int countPaths(int[][] grid) {
        Long[][] dp = new Long[grid.length][grid[0].length];
        long res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = res + dfs(i, j, dp, grid);
            }
        }
        return (int) (res % mod);
    }

    static long dfs(int i, int j, Long[][] dp, int[][] grid) {
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length) return 0;
        int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (dp[i][j] != null) return dp[i][j];
        dp[i][j] = 1L;
        for (int k = 0; k < direct.length; k++) {
            if (i + direct[k][0] < 0 || j + direct[k][1] < 0 || i + direct[k][0] >= dp.length || j + direct[k][1] >= dp[0].length
                    || grid[i][j] <= grid[i + direct[k][0]][j + direct[k][1]])
                continue;

            dp[i][j] += dfs(i + direct[k][0], j + direct[k][1], dp, grid);
        }
        dp[i][j] = (dp[i][j] % mod);
        return dp[i][j];
    }
}