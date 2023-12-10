class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int[][] temp = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if ((i & 1) == 0) {
                    temp[i][j] = mat[i][(j + k) % mat[0].length];
                } else {
                    temp[i][j] = mat[i][(j - k % mat[0].length + mat[0].length) % mat[0].length];
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (temp[i][j] != mat[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}