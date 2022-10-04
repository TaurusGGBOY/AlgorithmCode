import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] score = new int[words.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String s = words[i].substring(0, j + 1);
                map.merge(s, 1, Integer::sum);
            }
        }
        for (int i = 0; i < score.length; i++) {
            int j = 0;
            for (; j < words[i].length(); j++) {
                String s = words[i].substring(0, j + 1);
                score[i] += map.get(s);
                if (map.get(s) == 1) break;
            }
            score[i] += words[i].length() - j - 1;
        }
        return score;
    }
}