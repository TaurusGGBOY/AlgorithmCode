class Solution {
    public int countPyramids(int[][] grid) {
        int[][] gridReverse = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                gridReverse[grid.length - i - 1][j] = grid[i][j];
            }
        }
        return count(grid) + count(gridReverse);
    }

    int count(int[][] grid) {
        int[][] left = new int[grid.length][grid[0].length];
        int[][] right = new int[grid.length][grid[0].length];
        int[][] label = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            left[i][0] = grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
            right[i][grid[0].length - 1] = grid[i][grid[0].length-1];
            for (int j = grid[0].length - 2; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                if (i == 0) {
                    label[i][j] = 1;
                    continue;
                }
                label[i][j] = Math.min(Math.min(left[i][j], right[i][j]), label[i - 1][j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[0].length; j++) {
                res += Math.max(0, label[i][j] - 1);
            }
        }
        return res;
    }
}