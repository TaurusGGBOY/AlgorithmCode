import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    int min;

    public int minimizeTheDifference(int[][] mat, int target) {
        int[][] dis = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.sort(mat[i]);
        }
        int[] pos = new int[mat.length];
    }


}