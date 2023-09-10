import java.util.*;

class Solution {
    public int minimumMoves(int[][] grid) {
        int res = 0;
        List<int[]> zero = new ArrayList<>();
        List<int[]> multi = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zero.add(new int[]{i, j});
                } else if (grid[i][j] > 1) {
                    multi.add(new int[]{i, j});
                }
            }
        }

        while (!zero.isEmpty()) {
            int[] temp = new int[2];
            Arrays.fill(temp, Integer.MAX_VALUE);

            for (int i = 0; i < zero.size(); i++) {
                for (int j = 0; j < multi.size(); j++) {
                    int dis = Math.abs(zero.get(i)[0] - multi.get(i)[0]) + Math.abs(zero.get(i)[1] - multi.get(i)[1]);
                    if (dis < temp[0]) {

                    }
                }
            }

        }


        return res;
    }


}