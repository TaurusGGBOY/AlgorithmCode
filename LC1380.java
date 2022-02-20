import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] min = new int[matrix.length];
        int[] max = new int[matrix[0].length];
        Arrays.fill(min, 1000000);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (min[i] == matrix[i][j] && max[j] == matrix[i][j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}