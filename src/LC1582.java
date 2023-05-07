class Solution {
    public int numSpecial(int[][] mat) {
        int[] col = new int[mat.length];
        int[] row = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) continue;
                col[i]++;
                row[j]++;
            }
        }
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
              if(mat[i][j] == 1 && col[i] == 1 && row[j] == 1) res++;
            }
        }
        return res;
    }
}