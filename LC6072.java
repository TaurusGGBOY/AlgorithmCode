import java.util.Arrays;

class Solution {

    int max;
    // 2 5 10的累计个数
    int[][][] dpRow;
    int[][][] dpCol;
    int[][][] dp;

    public int maxTrailingZeros(int[][] grid) {
        dpRow = new int[grid.length][grid[0].length][3];
        dpCol = new int[grid.length][grid[0].length][3];
        dp = new int[grid.length][grid[0].length][3];
        getDp(grid);
        getDpRow(dp);
        getDpCol(dp);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max,
                        (Math.min(
                                dpCol[i][j][0] + dpRow[i][j][0] - dp[i][j][0],
                                dpCol[i][j][1] + dpRow[i][j][1] - dp[i][j][1])) +
                                dpCol[i][j][2] + dpRow[i][j][2] - dp[i][j][2]);
                max = Math.max(max,
                        (Math.min(
                                dpCol[dpCol.length - 1][j][0] - dpCol[i][j][0] + dpRow[i][j][0],
                                dpCol[dpCol.length - 1][j][1] - dpCol[i][j][1] + dpRow[i][j][1])) +
                                dpCol[dpCol.length - 1][j][2] - dpCol[i][j][2] + dpRow[i][j][2]);
                max = Math.max(max,
                        (Math.min(
                                dpCol[i][j][0] + dpRow[i][dpRow[0].length - 1][0] - dpRow[i][j][0],
                                dpCol[i][j][1] + dpRow[i][dpRow[0].length - 1][1] - dpRow[i][j][1])) +
                                dpCol[i][j][2] + dpRow[i][dpRow[0].length - 1][2] - dpRow[i][j][2]);
                max = Math.max(max,
                        (Math.min(
                                dpCol[dpCol.length - 1][j][0] - dpCol[i][j][0] + dpRow[i][dpRow[0].length - 1][0] - dpRow[i][j][0] + dp[i][j][0],
                                dpCol[dpCol.length - 1][j][1] - dpCol[i][j][1] + dpRow[i][dpRow[0].length - 1][1] - dpRow[i][j][1] + dp[i][j][1])) +
                                dpCol[dpCol.length - 1][j][2] - dpCol[i][j][2] + dpRow[i][dpRow[0].length - 1][2] - dpRow[i][j][2] + dp[i][j][2]);
            }
        }
        return max;
    }

    void getDp(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[] nums = getArray(grid[i][j]);
                for (int k = 0; k < nums.length; k++) {
                    dp[i][j][k] = nums[k];
                }
            }
        }
    }

    int[] getArray(int num) {
        int[] nums = new int[3];
        while (num != 0 && num % 10 == 0) {
            nums[2]++;
            num /= 10;
        }
        while (num != 0 && num % 5 == 0) {
            nums[1]++;
            num /= 5;
        }
        while (num != 0 && num % 2 == 0) {
            nums[0]++;
            num /= 2;
        }
        return nums;
    }

    void getDpRow(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                try {
                    for (int k = 0; k < dp[0][0].length; k++) {
                        dpRow[i][j][k] = dpRow[i][j - 1][k] + dp[i][j][k];
                    }
                } catch (Exception e) {
                    for (int k = 0; k < dp[0][0].length; k++) {
                        dpRow[i][j][k] = dp[i][j][k];
                    }
                }
            }
        }
    }

    void getDpCol(int[][][] dp) {
        for (int j = 0; j < dp[0].length; j++) {
            for (int i = 0; i < dp.length; i++) {
                try {
                    for (int k = 0; k < dp[0][0].length; k++) {
                        dpCol[i][j][k] = dpCol[i - 1][j][k] + dp[i][j][k];
                    }
                } catch (Exception e) {
                    for (int k = 0; k < dp[0][0].length; k++) {
                        dpCol[i][j][k] = dp[i][j][k];
                    }
                }
            }
        }
    }

}