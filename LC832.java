import java.util.Arrays;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A.length - 1 - j];
                A[i][A.length - 1 - j] = temp;
            }
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] ^= 1;
            }
        }
        return A;
    }
}