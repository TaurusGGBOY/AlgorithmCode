class Solution {
  public int tribonacci(int n) {
    int[] temp  = new int[n+1];
    if(n==0)
      return 0;
    if(n==1)
      return 1;
    if(n==2)
      return 1;
    temp[0]=0;
    temp[1]=1;
    temp[2]=1;
    for(int i=3;i<=n;i++)
    {
      temp[i] = temp[i - 1] + temp[i - 2] + temp[i - 3];
    }
    return temp[n];
  }
}