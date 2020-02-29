import java.util.Arrays;

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (min > A[i])
                min = A[i];
            if (max < A[i])
                max = A[i];
        }
        return Math.max(max - min - 2 * K, 0);
    }
}