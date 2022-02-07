import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] vis = new int[matrix.length][matrix[0].length];
        int x = 0, y = 0, d = 0;
        List<Integer> res = new ArrayList<>();
        vis[x][y] = 1;
        res.add(matrix[x][y]);
        while (true) {
            boolean flag = false;
            for (int i = 0; i < directions.length; i++) {
                while (x + directions[d][0] >= 0 && x + directions[d][0] < matrix.length && y + directions[d][1] >= 0 && y + directions[d][1] < matrix[0].length && vis[x + directions[d][0]][y + directions[d][1]] == 0) {
                    x = x + directions[d][0];
                    y = y + directions[d][1];
                    vis[x][y] = 1;
                    res.add(matrix[x][y]);
                    flag = true;
                }
                d = (d + 1) % directions.length;
            }
            if(!flag) break;
        }
        return res;
    }
}