import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] set = new int[101];
        Arrays.fill(set,-1);
        for (int i = 0; i < pieces.length; i++) {
            set[pieces[i][0]] = i;
        }
        int pos = 0;
        while (pos < arr.length) {
            if (set[arr[pos]] == -1) {
                return false;
            }
//            System.out.println("这儿返回的？");
            int index = set[arr[pos]];
            int j = 0;
            while (j < pieces[index].length && pos < arr.length && pieces[index][j] == arr[pos]) {
                j++;
                pos++;
            }
            if(j<pieces[index].length)
                return false;
        }
        return true;
    }
}