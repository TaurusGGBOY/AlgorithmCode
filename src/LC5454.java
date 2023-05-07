import java.util.Arrays;

class Solution {
    public int numSubmat(int[][] mat) {
        int res = 0;
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (mat[i][j] == 0)
                    continue;
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    res++;
                    continue;
                }
                for (int k=1;k<=i;k++)
                {
                    for(int l=1;l<j;l++)
                    {
                        if(mat[i][j]==0)
                            break;
                        dp[i][j]++;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}