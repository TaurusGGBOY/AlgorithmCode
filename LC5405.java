class Solution {
    public int countTriplets(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                for (int k = j; k < dp.length; k++) {
                    int temp = i == 0 ? 0 : dp[i - 1];
                    if ((temp ^ dp[j - 1]) == (dp[k] ^ dp[j - 1]))
                        count++;
                }
            }
        }
        return count;
    }
}