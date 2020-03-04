import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = 0;
        int j = 0;
        if(B==null||B.length==0)
            return;
        while (i < m) {
            if (A[i]>B[j])
            {
                int temp = A[i];
                A[i]=B[j];
                B[j]=temp;
                Arrays.sort(B);
            }
            i++;
        }
        System.arraycopy(B, j, A, i, B.length - j);
    }
}