import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public long minimumCost(String s) {
        long res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += s.charAt(i) == s.charAt(i - 1) ? 0 : Math.min(i, s.length() - i);
        }
        return res;
    }

}