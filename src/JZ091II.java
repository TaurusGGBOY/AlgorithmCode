import java.util.Arrays;

class Solution {
    public int minCost(int[][] costs) {
        int[] dp = new int[]{costs[0][0], costs[0][1], costs[0][2]};
        for (int i = 1; i < costs.length; i++) {
            int[] temp = new int[]{dp[0], dp[1], dp[2]};
            dp[0] = Math.min(temp[1] + costs[i][0], temp[2] + costs[i][0]);
            dp[1] = Math.min(temp[0] + costs[i][1], temp[2] + costs[i][1]);
            dp[2] = Math.min(temp[0] + costs[i][2], temp[1] + costs[i][2]);
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}