class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int column = i;
            for (int row = 0; row < grid.length; row++) {

                try {
                    if (grid[row][column] == 1 && grid[row][column + 1] == -1) {
                        column = -1;
                        break;
                    }
                } catch (Exception e) {
                }
                try {
                    if (grid[row][column - 1] == 1 && grid[row][column] == -1) {
                        column = -1;
                        break;
                    }
                } catch (Exception e) {
                }
                if (grid[row][column] == 1) {
                    column++;
                } else {
                    column--;
                }
                if (column < 0 || column >= grid[0].length) {
                    column = -1;
                    break;
                }
            }
            ans[i] = column;
        }
        return ans;
    }
}