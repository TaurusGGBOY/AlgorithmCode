import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ji = new int[A.length / 2];
        int[] ou = new int[A.length / 2];
        int jiIndex=0;
        int ouIndex=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]%2==0)
                ou[ouIndex++]=A[i];
            else
                ji[jiIndex++]=A[i];
        }
        Arrays.sort(ji);
        Arrays.sort(ou);
        jiIndex=0;
        ouIndex=0;
        for (int i = 0; i < A.length; i++) {
            if(i%2==0)
                A[i] = ou[ouIndex++];
            else
                A[i] = ji[jiIndex++];
        }
        return A;
    }
}