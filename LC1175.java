class Solution {
    public int numPrimeArrangements(int n) {
        if (n == 1)
            return 1;
        int priCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPri(i))
                priCount++;
        }
        int res = 1;
        long[] dp = new long[101];
        dp[0] = 1;
        for (int i = 1; i <= Math.max(priCount, n - priCount); i++) {
            dp[i] = (dp[i - 1] * i) % 1000000007;
        }
//        System.out.println(dp[n-priCount]);
//        System.out.println(dp[priCount]);
        return (int) ((dp[n - priCount] * dp[priCount]) % 1000000007);
    }

    boolean isPri(int num) {
        if (num <= 1)
            return false;
        if(num==2)
            return true;
        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if (num % i == 0)
                return false;
        }
//        System.out.println(num);
        return true;
    }

}