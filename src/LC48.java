class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = i; j < c - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[r - 1 - j][i];
                matrix[r - 1 - j][i] = matrix[r - 1 - i][c - 1 - j];
                matrix[r - 1 - i][c - 1 - j] = matrix[j][c - i - 1];
                matrix[j][c - i - 1] = temp;
            }
        }
    }
}