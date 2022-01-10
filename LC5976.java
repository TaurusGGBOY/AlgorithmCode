class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < matrix[0].length; j++) {
                if (temp[matrix[i][j]-1] == 1) {
                    return false;
                }
                temp[matrix[i][j]-1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (temp[matrix[j][i]-1] == 1) {
                    return false;
                }
                temp[matrix[j][i]-1] = 1;
            }
        }
        return true;
    }
}