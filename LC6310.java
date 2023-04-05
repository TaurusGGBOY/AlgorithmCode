import java.util.Arrays;

class Solution {
    final static int MOD = (int) (1e9 + 7);

    public int waysToReachTarget(int target, int[][] types) {
        // 和能到达dp[i]的可能数量
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 从左到右 一个个算
        for (int i = 0; i < types.length; i++) {
            int[] type = types[i];
            // 每一种选0到type[0]个
            for (int j = 0; j <= type[0]; j++) {
                // 这个数是小于2500的
                int sum = j * type[1];
                if (sum > target) break;
                for (int k = 0; (k < dp.length) && (k + sum < dp.length); k++) {
                    dp[k + sum] = (dp[k + sum] + dp[k]) % MOD;
                }
            }
        }
        return dp[dp.length - 1];
    }
}