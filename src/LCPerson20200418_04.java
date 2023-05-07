import java.util.Arrays;
// 失败
class Solution {
    public int minJump(int[] jump) {
        int[] dp = new int[jump.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 2);
        dp[0] = 0;
        for (int i = 0; i < jump.length; i++) {
            if (dp[i] != Integer.MAX_VALUE - 2) {
                if (i + jump[i] < jump.length) {
                    dp[i + jump[i]] = Math.min(dp[i + jump[i]], dp[i] + 1);
                    for (int j = i + 1; j < i + jump[i]; j++) {
                        dp[j] = Math.min(dp[j], dp[i + jump[i]] + 1);
                    }
                } else {
                    dp[jump.length] = Math.min(dp[jump.length], dp[i] + 1);
                    return dp[jump.length];
                }
            }
        }
        return dp[jump.length];
    }

    void print(int[] is) {
        for (int i = 0; i < is.length; i++)
            System.out.print(is[i] + " ");
        System.out.println();
    }
}