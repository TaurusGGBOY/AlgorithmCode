import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> AB = new HashMap<>();

        for (int i : A) {
            for (int j : B) {
                AB.merge(i + j, 1, (newval, oldval) -> newval + oldval);
            }
        }
        int res = 0;
        for (int i : C) {
            for (int j : D) {
                res += AB.getOrDefault(-i-j,0);
            }
        }
        return res;

    }
}