import java.util.Arrays;

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int[] dp = new int[2];
        int max = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == '_') {
                dp[0] = dp[0] + 1;
                dp[1] = dp[1] + 1;
            } else if (c == 'R') {
                dp[0] = dp[0] - 1;
                dp[1] = dp[1] + 1;
            } else {
                dp[0] = dp[0] + 1;
                dp[1] = dp[1] - 1;
            }
        }
        return Math.max(dp[0], dp[1]);
    }
}