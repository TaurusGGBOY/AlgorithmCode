import java.util.*;

class Solution {

    final static int MOD = 1000000007;
    long[][] dp;


    public int idealArrays(int n, int maxValue) {
        dp = new long[2][maxValue + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= maxValue; i++) {
            Set<Integer> set = new HashSet<>();
            int j = 1;
            while (i * j <= maxValue) {
                set.add(i * j);
                j++;
            }
            map.put(i, set);
        }

        int pos = 0;
        for (int i = 0; i < dp[0].length; i++) dp[pos][i] = 1;
        pos = 1;
        for (int k = 2; k <= n; k++) {
            int prev = (pos + 1) % 2;
            for (int i = 1; i <= maxValue; i++) {
                dp[pos][i] = 0;
                Set<Integer> set = map.get(i);
                for (int num : set) dp[pos][i] = (dp[pos][i] + dp[prev][num]) % MOD;
            }
            pos = (pos + 1) % 2;
        }

        long res = 0;
        pos = (pos + 1) % 2;
        for (int i = 0; i < dp[0].length; i++) res = (res + dp[pos][i]) % MOD;
        return (int) res;
    }

//    public int dfs(int prev, int n, int maxValue) {
//        if (n == 0) return 1;
//        int p = maxValue / prev;
//        long res = 0;
//        for (int i = 1; i <= p; i++) {
//            res = (res + dfs(prev * i, n - 1, maxValue)) % MOD;
//        }
//        return (int) res;
//    }
}