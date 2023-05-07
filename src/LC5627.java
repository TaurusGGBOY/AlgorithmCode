import java.util.Arrays;

class Solution {
    public int stoneGameVII(int[] stones) {
        int sum =0;
        for (int stone : stones) {
            sum += stone;
        }
        int[][] dp = new int[stones.length+1][stones.length+1];

        int temp;
        for(int i =0;i<stones.length;i++)
        {
            temp = sum;
            for(int j =0;j<stones.length;j++)
            {
                dp[i][j]=Math.max(dp[])
            }
        }
        return dp[]
    }
}