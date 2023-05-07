class Solution {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length() + 1];
        int b = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'b') {
                dp[i] = dp[i - 1];
                b++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, b);
            }
        }
        return dp[s.length()];
    }
}