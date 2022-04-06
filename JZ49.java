import java.util.*;

class Solution {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] p = new int[]{1, 1, 1};
        for (int i = 2; i <= n; i++) {
            int[] num = new int[]{dp[p[0]] * 2, dp[p[1]] * 3, dp[p[2]] * 5};
            dp[i] = Math.min(Math.min(num[0], num[1]), num[2]);
            for (int j = 0; j < num.length; j++) if (dp[i] == num[j]) p[j]++;
        }
        return dp[n];
    }


}