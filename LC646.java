import java.util.*;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int curr = Integer.MIN_VALUE, res = 0;
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                res++;
            }
        }
        return res;

    }
}