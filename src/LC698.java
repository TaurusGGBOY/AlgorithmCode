import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = 1 << nums.length;
        boolean[] dp = new boolean[n];
        // 最有哲学的是这个sum的设置 很难想
        // 要么sum就小于p，说明还没装满，要么，就刚好装满，换一桶
        // 理解这还是一种贪心，但是会提前算好所有少一个桶时候的情况，让你加入到结果集的时候，前面已经满足了，放心加进去
        int[] sum = new int[n];
        int s = Arrays.stream(nums).sum();
        if (s % k != 0) {
            return false;
        }
        int p =  s / k;

        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                if (sum[i] + nums[j] > p) {
                    continue;
                }

                if (((i >> j) & 1) == 1) {
                    continue;
                }

                int next = i | 1 << j;
                sum[next] = (sum[i] + nums[j]) % p;
                dp[next] = true;
            }
        }

        return dp[n-1];
    }
}