import java.util.*;

class Solution {
    public boolean validPartition(int[] nums) {
        int i = 0;
        boolean[] dp = new boolean[nums.length];
        while (i < nums.length) {
            if (i > 0 && !dp[i - 1]) {
                i++;
                continue;
            }
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) dp[i + 1] = true;
            if (i + 2 < nums.length && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) dp[i + 2] = true;
            if (i + 2 < nums.length && nums[i] == nums[i + 1] - 1 && nums[i] == nums[i + 2] - 2) dp[i + 2] = true;
            i++;
        }
        return dp[nums.length - 1];
    }
}