import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int i = 0;
        int res = 1;
        int j = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            else
            {
                set.add(s.charAt(j++));
                res = Math.max(set.size(), res);
            }
        }
        return res;
    }
}