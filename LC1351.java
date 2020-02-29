class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 1] >= 0)
                continue;
            count++;
            for (int j = grid[0].length - 2; j >= 0; j--) {
                if (grid[i][j] >= 0)
                    break;
                count++;
            }
        }
        return count;
    }
}