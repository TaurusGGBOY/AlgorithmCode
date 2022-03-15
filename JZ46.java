import java.util.Arrays;

class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 5];
        Arrays.fill(dp, 1);
        for (int i = str.length() - 2; i >= 0; i--) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (c1 == '1') {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (c1 == '2' && c2 <= '5') {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}