import java.util.HashSet;

class Solution {
    public int similarPairs(String[] words) {
        boolean[][] alpha = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                alpha[i][c - 'a'] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean flag = true;
                for (int k = 0; k < alpha[0].length; k++) {
                    if (alpha[i][k] != alpha[j][k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) res++;
            }
        }
        return res;
    }
}