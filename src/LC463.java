class Solution {
    public int islandPerimeter(int[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    try {
                        c += 1 ^ grid[i - 1][j];
                    } catch (Exception e) {
                        c++;
                    }
                    try {
                        c += 1 ^ grid[i + 1][j];
                    } catch (Exception e) {
                        c++;
                    }
                    try {
                        c += 1 ^ grid[i][j - 1];
                    } catch (Exception e) {
                        c++;
                    }
                    try {
                        c += 1 ^ grid[i][j + 1];
                    } catch (Exception e) {
                        c++;
                    }
                }
            }
        }
        return c;
    }

}