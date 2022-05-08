import java.util.*;

class Solution {
    public int countTexts(String pressedKeys) {
        long res = 1;
        char c = pressedKeys.charAt(0);
        int mod = 1000000007;
        Set<Character> set = new HashSet<>(Arrays.asList('7', '9'));
        long[] count = new long[5];
        count[1] = 1;
        long temp = 1;

        for (int i = 1; i < pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i) == c) {
                if (set.contains(c)) {
                    count[4] = count[3];
                    count[3] = count[2];
                    count[2] = count[1];
                    count[1] = temp;
                    temp = (count[1] + count[2] + count[3] + count[4]) % mod;
                } else {
                    count[3] = count[2];
                    count[2] = count[1];
                    count[1] = temp;
                    temp = (count[1] + count[2] + count[3]) % mod;
                }
            } else {
                res = (temp * res) % mod;
                c = pressedKeys.charAt(i);
                Arrays.fill(count, 0);
                count[1] = 1;
                temp = 1;
            }
        }
        res = (temp * res) % mod;
        return (int) res;
    }
}