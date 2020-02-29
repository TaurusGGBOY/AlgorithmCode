class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
    }
}

// 0 0 -> 0 2
// 0 2 -> 2 2
// 2 2 -> 2 0
// 2 0 -> 0 0