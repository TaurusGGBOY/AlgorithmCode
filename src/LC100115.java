class Solution {
    public int findChampion(int[][] grid) {
        int[] win = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    ++win[j];
                }
            }
        }

        for (int i = 0; i < win.length; i++) {
            if (win[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}