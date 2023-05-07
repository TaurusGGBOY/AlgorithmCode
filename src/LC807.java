import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxCol = new int[grid[0].length];
        int[] maxRow = new int[grid.length];
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                maxCol[i] = Math.max(maxCol[i], grid[j][i]);
                maxRow[j] = Math.max(maxRow[j], grid[j][i]);
                res += grid[j][i];
            }
        }
//        System.out.println(Arrays.toString(maxRow));
//        System.out.println(Arrays.toString(maxCol));

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res -=  Math.min(maxRow[i], maxCol[j]);
            }
        }
//        for (int i = 0; i < grid.length; i++) {
//            System.out.println(Arrays.toString(grid[i]));
//        }
        return -res;
    }
}