class Solution {
    final static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] g;
    int[] parents;
    int[][] vis;

    public int numEnclaves(int[][] grid) {
        g = grid;
        parents = new int[grid.length * grid[0].length];
        redVis = new int[grid.length][grid[0].length];

        for (int i = 0; i < parents.length; i++) parents[i] = i;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && g[i][j] == 1 && redVis[i][j] == 0)
                    dfs(i, j);
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (g[i][j] == 1 && find(getIndex(i, j)) != 0) res++;
            }
        }
        return res;
    }

    int getIndex(int x, int y) {
        return x * g[0].length + y;
    }

    void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || g[x][y] == 0 || redVis[x][y] == 1) return;
        redVis[x][y] = 1;
        merge(getIndex(x, y), 0);
        for (int i = 0; i < directions.length; i++) dfs(directions[i][0] + x, directions[i][1] + y);
    }

    int find(int index) {
        if (parents[index] == index) return index;
        return parents[parents[index]];
    }

    void merge(int index, int parent) {
        parents[find(index)] = parents[find(parent)];
    }
}