import java.util.*;

class Solution {
    int[][] vis;
    List<List<Integer>> res;
    static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        vis = new int[heights.length][heights[0].length];

        if (dfs(heights, 0, 0)) res.add(new ArrayList<>(Arrays.asList(0, 0)));
        return res;
    }

    private boolean dfs(int[][] heights, int i, int j) {
        if (vis[i][j] == 1) return false;
        vis[i][j] = 1;
        boolean flag = false;
        for (int[] d : directions){
            if (i + d[0] < 0 || j + d[1] < 0 || i + d[0] >= heights.length || j + d[1] >= heights[0].length || heights[i + d[0]][j + d[1]] > heights[i][j])
                continue;
            flag = dfs(heights, i + d[0], j + d[1]);
        }
        if (flag) res.add(new ArrayList<>(Arrays.asList(i, j)));
        return flag;
    }
}