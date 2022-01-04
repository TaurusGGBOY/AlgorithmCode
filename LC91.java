class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i <= chars.length - 2; i++) {
            int a = chars[i + 1] - '0';
            int b = (chars[i] - '0') * 10 + a;
            if (a > 0 && a <= 9) dp[i + 2] = dp[i + 1];
            if (b >= 10 && b <= 26) dp[i + 2] += dp[i];
        }
        return dp[chars.length];
    }


}