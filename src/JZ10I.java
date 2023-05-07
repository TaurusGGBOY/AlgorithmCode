class Solution {
    int[] dp = new int[101];

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n - 1] == 0) dp[n - 1] = fib(n - 1);
        if (dp[n - 2] == 0) dp[n - 2] = fib(n - 2);
        return (dp[n - 1] + dp[n - 2]) % 1000000007;
    }
}