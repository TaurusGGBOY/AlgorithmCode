class Solution {
    int[][] visited;
    final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j, grid);
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }

    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = 1;
        count++;
        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1], grid);
        }
    }
}