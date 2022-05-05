class Solution {
    public int findTheWinner(int n, int k) {
        // 已知第n轮的下标
        int dp = 1;
        // 从n-1轮开始求，求到第1轮就是胜者在最开始的下标
        for (int i = n - 1; i >= 1; i--) {
            dp = (dp + k - 1) % (n - i + 1) + 1;
        }
        return dp;
    }
}