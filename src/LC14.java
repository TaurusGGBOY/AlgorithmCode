import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int r = Integer.MAX_VALUE;
        for (String str : strs) {
            r = Math.min(r, str.length());
        }
        int l = 0;
        int m = (l + r) / 2;
        loop:
        while (l <= r) {
            String prefix = strs[0].substring(0, m);
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    r = m - 1;
                    m = (l + r) / 2;
                    continue loop;
                }
            }
            l = m + 1;
            m = (l + r) / 2;
        }
        return strs[0].substring(0, l - 1);
    }
}