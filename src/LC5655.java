import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int count = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    count++;
                    matrix[j][i] = count;
                } else {
                    count = 0;
                    matrix[j][i] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            int height = matrix[i][matrix[0].length - 1];
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                int dis = matrix[0].length - j;
                height = Math.min(height, matrix[i][j]);
                res = Math.max(res, height * dis);
            }
        }
        return res;
    }
}