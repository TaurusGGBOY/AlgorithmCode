import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            Arrays.sort(A);
            A[0]=-A[0];
        }
        int sum=0;
        for (int i = 0; i <A.length; i++) {
            sum+=A[i];
        }
        return sum;
    }
}
