// 失败
class Solution {
    public int reverseBits(int num) {
        char[] cstr = Integer.toBinaryString(num).toCharArray();
        int[] dp0 = new int[cstr.length];
        int[] dp1 = new int[cstr.length];

        int count= 0;
        int res =0;
        for(int i=0;i<cstr.length;i++)
        {
            if(cstr[i]=='1')
            {
                dp[0]++;
            }
            else
            {

            }
        }
    }
}