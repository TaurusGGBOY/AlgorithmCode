class Solution {
    public long beautifulSubstrings(String s, int k) {
        // 1. recond vowel == consonats - 1 && vowel == consonats + 1
        // 2. recond when condition 1 the value of (vowel * consonats - 1) % k
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] vowelsCount = new int[n];
        int[] consonantsCount = new int[n];

        for (int i = 0; i < n; i++) {
            vowelsCount[i] = (i > 0 ? vowelsCount[i - 1] : 0) + (isVowel(chars[i]) ? 1 : 0);
            consonantsCount[i] = (i > 0 ? consonantsCount[i - 1] : 0) + (isConsonant(chars[i]) ? 1 : 0);
        }

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + Math.min(vowelsCount[i], consonantsCount[i]);
                if (i >= k) {
                    dp[i][j] -= (j > 0 ? dp[i - k][j - 1] : 0);
                }
            }
        }

        return dp[n - 1][0];
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    private static boolean isConsonant(char c) {
        return "aeiou".indexOf(c) == -1;
    }
}