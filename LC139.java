import java.util.List;

class Solution {
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1];
        int[] alpha1 = new int[128];
        int[] alpha2 = new int[128];
        for (char c : s.toCharArray())
            alpha1[c - 'a'] = 1;
        for (String s1 : wordDict) {
            for (char c : s1.toCharArray())
                alpha2[c - 'a'] = 1;
        }

        for (int i = 0; i < 128; i++) {
            if (alpha1[i] > alpha2[i])
                return false;
        }
        return bfs(s, wordDict);

    }

    public boolean bfs(String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;
        if (dp[s.length()] == 1)
            return true;
        if (dp[s.length()] == -1)
            return false;
        for (String s1 : wordDict) {
            if (s.endsWith(s1)) {
                if (bfs(s.substring(0, s.length() - s1.length()), wordDict)) {
                    dp[s.length() - s1.length()] = 1;
                    return true;
                } else {
                    dp[s.length() - s1.length()] = -1;
                }
            }
        }
        return false;
    }
}