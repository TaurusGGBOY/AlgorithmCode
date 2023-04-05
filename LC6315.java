import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int res = 0;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (set.contains(w.charAt(0)) && set.contains(w.charAt(w.length() - 1))) {
                res++;
            }
        }
        return res;
    }
}