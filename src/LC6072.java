class Solution {
    // 2 5 10的累计个数
    int[][][] rows, cols, dp;
    int max;

    public int maxTrailingZeros(int[][] grid) {
        rows = new int[grid.length][grid[0].length][3];
        cols = new int[grid.length][grid[0].length][3];
        dp = new int[grid.length][grid[0].length][3];
        getDp(grid);
        getDpRow(dp);
        getDpCol(dp);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max,
                        (Math.min(
                                cols[i][j][0] + rows[i][j][0] - dp[i][j][0],
                                cols[i][j][1] + rows[i][j][1] - dp[i][j][1])) +
                                cols[i][j][2] + rows[i][j][2] - dp[i][j][2]);
                max = Math.max(max,
                        (Math.min(
                                cols[cols.length - 1][j][0] - cols[i][j][0] + rows[i][j][0],
                                cols[cols.length - 1][j][1] - cols[i][j][1] + rows[i][j][1])) +
                                cols[cols.length - 1][j][2] - cols[i][j][2] + rows[i][j][2]);
                max = Math.max(max,
                        (Math.min(
                                cols[i][j][0] + rows[i][rows[0].length - 1][0] - rows[i][j][0],
                                cols[i][j][1] + rows[i][rows[0].length - 1][1] - rows[i][j][1])) +
                                cols[i][j][2] + rows[i][rows[0].length - 1][2] - rows[i][j][2]);
                max = Math.max(max,
                        (Math.min(
                                cols[cols.length - 1][j][0] - cols[i][j][0] + rows[i][rows[0].length - 1][0] - rows[i][j][0] + dp[i][j][0],
                                cols[cols.length - 1][j][1] - cols[i][j][1] + rows[i][rows[0].length - 1][1] - rows[i][j][1] + dp[i][j][1])) +
                                cols[cols.length - 1][j][2] - cols[i][j][2] + rows[i][rows[0].length - 1][2] - rows[i][j][2] + dp[i][j][2]);
            }
        }
        return max;
    }

    void getDp(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[] nums = getArray(grid[i][j]);
                for (int k = 0; k < nums.length; k++) dp[i][j][k] = nums[k];
            }
        }
    }

    int[] getArray(int num) {
        int[] nums = new int[3];
        for (; num != 0 && num % 10 == 0; num /= 10) nums[2]++;
        for (; num != 0 && num % 5 == 0; num /= 5) nums[1]++;
        for (; num != 0 && num % 2 == 0; num /= 2) nums[0]++;
        return nums;
    }

    void getDpRow(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                try {
                    for (int k = 0; k < dp[0][0].length; k++) rows[i][j][k] = rows[i][j - 1][k] + dp[i][j][k];
                } catch (Exception e) {
                    for (int k = 0; k < dp[0][0].length; k++) rows[i][j][k] = dp[i][j][k];
                }
            }
        }
    }

    void getDpCol(int[][][] dp) {
        for (int j = 0; j < dp[0].length; j++) {
            for (int i = 0; i < dp.length; i++) {
                try {
                    for (int k = 0; k < dp[0][0].length; k++) cols[i][j][k] = cols[i - 1][j][k] + dp[i][j][k];
                } catch (Exception e) {
                    for (int k = 0; k < dp[0][0].length; k++) cols[i][j][k] = dp[i][j][k];
                }
            }
        }
    }

}