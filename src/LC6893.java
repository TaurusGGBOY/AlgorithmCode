import java.util.ArrayList;
import java.util.List;

class Solution {
    static int res;

    public int specialPerm(int[] nums) {
        long[][] dp = new long[(int) Math.pow(2, nums.length)][nums.length];
        for (int j = 0; j < dp[0].length; j++) {
            dp[1 << j][j] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if ((i & 1 << k) == 0 && k != j) {
                        if (nums[k] % nums[j] == 0 || nums[j] % nums[k] == 0)
                            dp[i | 1 << k][k] += dp[i][j];
                    }
                }
            }
        }

        long res = 0;
        for (long num : dp[dp.length - 1]) {
            res += num;
        }
        return (int) (res % 1000000007);
    }


}