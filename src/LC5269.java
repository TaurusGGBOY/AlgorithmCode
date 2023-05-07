import java.util.*;

class Solution {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // 状态压缩
        int[] dp = new int[k + 2];
        int n = piles.size();
        for (int i = 0; i < n; i++) {
            List<Integer> p = piles.get(i);
            int q = p.size();
            // 前缀和方便运算
            for (int j = 0; j < q - 1; j++) p.set(j + 1, p.get(j) + p.get(j + 1));
            // 前面几次迭代基本不影响dp
            for (int j = k; j >= 0; j--) {
                // 因为是从高向低迭代的，所以 一轮里面dp[j+m]不会影响dp[j]
                // 第i个pipe往结果里面加，看最优解能是多少
                for (int m = 1; m <= q && j + m <= k; m++) {
                    // 状态压缩 dp[j] 首先一定是之前i列的 所以不用怕dp[j+m]覆盖掉dp[j]
                    dp[j + m] = Math.max(dp[j + m], dp[j] + p.get(m - 1));
                }
            }
        }
        return dp[k];
    }


}