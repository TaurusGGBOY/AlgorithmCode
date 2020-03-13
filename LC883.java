class Solution {
    public int projectionArea(int[][] grid) {
        int[] left = new int[grid.length];
        int[] down = new int[grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    count++;
                    left[i] = Math.max(left[i], grid[i][j]);
                    down[j] = Math.max(down[j], grid[i][j]);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            count+=left[i];
        }
        for (int j = 0; j < grid[0].length; j++) {
            count += down[j];
        }
        return count;

    }
}