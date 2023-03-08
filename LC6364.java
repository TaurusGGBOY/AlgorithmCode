import java.math.BigInteger;
import java.util.*;

class Solution {
    // 1 4 9 16 25
    // 有多少个 因子不交叉的子集
    final static int MOD = (int) (1e9 + 7);
    final static int[] a = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int squareFreeSubsets(int[] nums) {
        int[] dp = new int[1024];
        int[] f = new int[31];
        // 空集肯定是有的
        dp[0] = 1;
        for (int i = 0; i < f.length; i++) f[i] = factor(i);

        for (int x : nums) {
            if (f[x] < 0) continue;
            // 10个质因子一共有1024种分布 遍历每一种分布
            for (int i = 0; i < 1024; i++) {
                // 如果这种分布和x的分布有交叉，则不计入子集结果
                if ((i & f[x]) != 0) continue;
                // 如果无交叉，则将二者相或的意思是，两个质因子集合求并
                // 如果这种集合和f[x]的分布无交叉，那么你应该加入到你们并集的结果子集中
                // 需要注意的是dp[xxxx]里面的元素数量是集合数量，每个结合他们的质因子都是不相交的
                dp[i | f[x]] = (dp[i | f[x]] + dp[i]) % MOD;
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) res = (res + dp[i]) % MOD;
        return (res - 1) % MOD;
    }

    // 质因子分布映射成一个数
    int factor(int x) {
        int y = 0;
        for (int i = 0; i < a.length; i++) {
            if (x % a[i] == 0) {
                x /= a[i];
                y |= 1 << i;
            }
            if (x % a[i] == 0) return -1;
        }
        return y;
    }
}