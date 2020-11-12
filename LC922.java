import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i=0;
        int j =A.length-1;
        for (; i < A.length; i+=2) {
            if(A[i]%2==1)
            {
                while(A[j]%2==1)
                {
                    j -= 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}