import java.util.Arrays;

class Solution {
    final static int MAXN = 25;
    int res;
    final static int[][] ds = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int getMaximumGold(int[][] grid) {
        res = 0;
        int[][] vis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, vis, 0, 0);
            }
        }
        return res;
    }

    void dfs(int[][] grid, int x, int y, int[][] vis, int depth, int v) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || vis[x][y] == 1 || depth > MAXN)
            return;
        vis[x][y] = 1;
        v += grid[x][y];
//        System.out.println("x,y,v" + x + " " + y + " " + v);
        res = Math.max(res, v);
        for (int[] d : ds) {
            dfs(grid, x + d[0], y + d[1], vis, depth + 1, v);
        }
        vis[x][y] = 0;
    }

    void reset(int[][] vis) {
        for (int[] v : vis) {
            Arrays.fill(v, 0);
        }
    }
}