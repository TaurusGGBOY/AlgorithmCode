import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        int[] start = new int[]{0, 0};
        for (int i = 1; i < grid.length * grid[0].length; i++) {
            int[] end = map.get(i);
            if (!check(start, end)) return false;
            start = end;
//            System.out.println(start[0] + " " + start[1] + " " + grid[start[0]][start[1]]);
        }
//        System.out.println();
        return true;
    }

    boolean check(int[] start, int[] end) {
        int disX = Math.abs(start[0] - end[0]);
        int disY = Math.abs(start[1] - end[1]);
        if (disX == 2 && disY == 1) return true;
        if (disX == 1 && disY == 2) return true;
        return false;
    }
}