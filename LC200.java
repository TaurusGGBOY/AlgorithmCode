class Solution {
    int[][] vis;
    char[][] gr;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int res = 0;
        redVis = new int[grid.length][grid[0].length];
        gr = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (redVis[i][j] == 1 || grid[i][j] == '0') continue;
                res++;
                dfs(i, j);
            }
        }
        return res;
    }

    void dfs(int x, int y) {
        if (x < 0 || x >= redVis.length || y < 0 || y >= redVis[0].length || redVis[x][y] == 1 || gr[x][y] == '0') return;
        redVis[x][y] = 1;
        for (int[] d : directions) dfs(d[0] + x, d[1] + y);
    }
}