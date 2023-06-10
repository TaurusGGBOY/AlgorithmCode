import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] tL = new int[grid.length][grid[0].length];
        int[][] bR = new int[grid.length][grid[0].length];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            set.clear();
            int x = i;
            int y = grid[0].length - 1;
            while (x >= 0 && y >= 0) {
                bR[x][y] = set.size();
                set.add(grid[x][y]);
                x--;
                y--;
            }
        }

        for (int j = 0; j < grid[0].length - 1; j++) {
            set.clear();
            int x = grid.length - 1;
            int y = j;
            while (x >= 0 && y >= 0) {
                bR[x][y] = set.size();
                set.add(grid[x][y]);
                x--;
                y--;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            set.clear();
            int x = i;
            int y = 0;
            while (x < grid.length && y < grid[0].length) {
                tL[x][y] = set.size();
                set.add(grid[x][y]);
                x++;
                y++;
            }
        }

        for (int j = 1; j < grid[0].length - 1; j++) {
            set.clear();
            int x = 0;
            int y = j;
            while (x < grid.length && y < grid[0].length) {
                tL[x][y] = set.size();
                set.add(grid[x][y]);
                x++;
                y++;
            }
        }

        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res[i][j] = Math.abs(bR[i][j] - tL[i][j]);
            }
        }

//        System.out.println(Arrays.deepToString(tL));
//        System.out.println(Arrays.deepToString(bR));

        return res;
    }
}