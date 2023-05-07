import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (res.isEmpty()) {
                res.add(word);
                continue;
            }
            int[] alpha1 = new int[26];
            int[] alpha2 = new int[26];
            String word1 = res.get(res.size() - 1);
            if (word.equals(word1)) continue;
            for (int i = 0; i < word1.length(); i++) {
                alpha1[word1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < word.length(); i++) {
                alpha2[word.charAt(i) - 'a']++;
            }
            boolean flag = false;
            for (int i = 0; i < alpha1.length; i++) {
                if (alpha1[i] != alpha2[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) continue;
            res.add(word);
        }
        return res;
    }
}