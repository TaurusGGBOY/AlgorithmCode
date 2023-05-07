import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int radix = 1;
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i] - 'A'+1) * radix;
            radix *= 26;
        }
        return res;
    }
}