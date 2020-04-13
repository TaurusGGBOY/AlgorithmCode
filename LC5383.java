class Solution {
  long[] dp = new long[5001];
  public int numOfWays(int n) {
      dp[1]=12;
      dp[2]=54;
      dp[3]=246;
      //k=3: a(n) = 5*a(n-1) -2*a(n-2)
    for(int i=4;i<=n;i++)
    {
      dp[i]=(5*dp[i-1]-2*dp[i-2])%(1000000000+7);
      while(dp[i]<0)
      {
        dp[i]+=1000000000+7;
      }
    }

    return (int)(dp[n]);
  }

}