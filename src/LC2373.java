class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid[0].length-2; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        max =Math.max(max, grid[i+k][j+m]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}