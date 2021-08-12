import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            char left = chars[i];
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                char right = chars[j];
                if (left == right) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}