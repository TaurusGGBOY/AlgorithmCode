import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < chars.length; i++) dp[i][i] = true;
        String max = "";
        for (int len = 0; len < chars.length; len++) {
            for (int i = 0, j = i + len; i < chars.length && j < chars.length; i++, j = i + len) {
                if ((i + 1 > j - 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                if (dp[i][j] && len + 1 > max.length()) max = s.substring(i, j + 1);
            }
        }
//        System.out.println(Arrays.toString(dp[0]));
//        System.out.println();
        return max;
    }

}