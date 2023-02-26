import java.math.BigInteger;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        long mod = 0;
        int[] res = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int c = (int) (word.charAt(i) - '0');
            mod = (mod * 10 + c) % m;
            if (mod == 0) res[i] = 1;
            else res[i] = 0;
        }
        return res;
    }
}