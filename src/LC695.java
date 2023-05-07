class Solution {
    int count;
    int max;
    int[][] g;
    int[][] vis;
    final static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        count = 0;
        max = 0;
        g = grid;
        redVis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count = 0;
                dfs(i, j);
            }
        }
        return max;
    }

    void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || g[x][y] == 0 || redVis[x][y] == 1) return;
        redVis[x][y] = 1;
        count++;
        max = Math.max(count, max);
        for (int[] d : directions) dfs(x + d[0], y + d[1]);
    }
}