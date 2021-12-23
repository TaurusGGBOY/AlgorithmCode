import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean[][] vis;
    int[] dir;
    Set<int[]> set;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        vis = new boolean[grid.length][grid[0].length];
        dir = new int[]{0, 1, 0, -1, 1, 0, -1, 0};
        set = new HashSet<>();

        dfs(grid, row, col);
        for (int[] points : set) {
            grid[points[0]][points[1]] = color;
        }
        return grid;
    }

    void dfs(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return;
        }
        if (vis[row][col]) {
            return;
        }
        vis[row][col] = true;
        if (board(grid, row, col)) {
            set.add(new int[]{row, col});
        }
        for (int i = 0; i < dir.length / 2; i++) {
            try {
                if (grid[row][col] == grid[row + dir[2 * i]][col + dir[2 * i + 1]]) {
                    dfs(grid, row + dir[2 * i], col + dir[2 * i + 1]);
                }
            } catch (Exception e) {
            }
        }
    }

    boolean board(int[][] grid, int row, int col) {
        if (row == grid.length - 1 || row == 0 || col == grid[0].length - 1 || col == 0) {
            return true;
        }
        for (int i = 0; i < dir.length / 2; i++) {
            if (grid[row][col] != grid[row + dir[2 * i]][col + dir[2 * i + 1]]) {
                return true;
            }
        }
        return false;
    }
}