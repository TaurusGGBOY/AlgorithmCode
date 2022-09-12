import java.util.Arrays;

class Solution {
    public int partitionString(String s) {
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                res++;
                Arrays.fill(count, 0);
            }
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                res++;
                break;
            }
        }
        return res;

    }
}