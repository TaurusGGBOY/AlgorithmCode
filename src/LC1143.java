class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 1. 状态的定义
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 2. 状态的初始化
        // 初始化第一个
        // 3. 状态转移的方向
        // 从左到右 从上到下
        for (int i = 1; i <= text1.length(); i++) {
            char c = text1.toCharArray()[i - 1];
            char[] cstr2 = text2.toCharArray();
            for (int j = 1; j <= text2.length(); j++) {
                // 4. 状态转移方程
                if (c == cstr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 5. 返回最终结果
        return dp[text1.length()][text2.length()];
    }
}