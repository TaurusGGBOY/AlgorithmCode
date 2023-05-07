import java.util.Arrays;

class Solution {
    static int[][] dp;
    static int[][] visited;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        visited = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        visited[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            visited[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            visited[0][i] = 1;
        }
        int dfs = dfs(grid, grid.length - 1, grid[0].length - 1);
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }

        return dfs;
    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (visited[i][j] == 1)
            return dp[i][j];
        int left = dfs(grid, i, j - 1);
        int up = dfs(grid, i - 1, j);
        dp[i][j] = Math.min(left, up) + grid[i][j];
        visited[i][j] = 1;
        return dp[i][j];
    }

}