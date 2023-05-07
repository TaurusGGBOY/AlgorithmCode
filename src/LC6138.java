import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestIdealString(String s, int k) {
        int[] alpha = new int[26];
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int temp = alpha[c - 'a'];
            int flag = 0;
            for (int j = Math.max(c - 'a' - k, 0); j <= Math.min(c - 'a' + k, 'z' - 'a'); j++) {
                if (j == c - 'a' && !set.contains(c)) continue;
                temp = Math.max(alpha[j] + 1, temp);
                flag = 1;
            }
            if (temp == 0) temp = 1;
            alpha[c - 'a'] = temp;
            set.add(c);
            res = Math.max(alpha[c - 'a'], res);
        }
        return res;
    }
}