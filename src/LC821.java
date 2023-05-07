import java.util.Arrays;

class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        Arrays.fill(res, s.length());
        int pos = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) pos = i;
            if (pos < 0) continue;
            res[i] = Math.min(res[i], i - pos);
        }
        pos = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) pos = i;
            if (pos < 0) continue;
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}