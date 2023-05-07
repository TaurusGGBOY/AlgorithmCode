import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0)
            return new int[0];
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            set.add(i * shorter + j * longer);
        }
        int[] res = new int[set.size()];
        int i=0;
        for(int num:set)
        {
            res[i++] = num;
        }
        Arrays.sort(res);
        return res;
    }

}