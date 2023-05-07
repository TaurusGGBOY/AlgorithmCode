import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] res = new int[k + 1];
        for (int num : arr) {
            int temp = num % k;
            if (temp < 0) {
                temp += k;
            }
            res[temp]++;
        }
//        for(int i=0;i<k;i++)
//        {
//            System.out.print(res[i]+" ");
//        }
//        System.out.println();

        for (int i = 1; i <= k / 2; i++) {
            if (res[i] != res[k - i])
                return false;
        }
        if (k % 2 == 0)
            return res[k / 2] % 2 == 0;
        return true;
    }
}