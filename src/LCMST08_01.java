class Solution {
    public int waysToStep(int n) {
        int size = Math.max(n+1,4);
        int[] dp = new int[size];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<dp.length;i++)
        {
            dp[i]=((dp[i-3]+dp[i-2])%1000000007+dp[i-1])%1000000007;
        }
        return dp[n];
    }
}