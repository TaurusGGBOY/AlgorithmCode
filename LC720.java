import java.util.*;

class Solution {

    public String longestWord(String[] words) {
        // 状态 0 不知道 1 可以组成 2 不能组成
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String res = "";
        for (String word : words) {
            boolean flag = true;
            for (int i = word.length() - 1; i > 0; i--) {
                if (!set.contains(word.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (flag && (res.isEmpty() || res.length() < word.length() || (res.length() == word.length() && res.compareTo(word) > 0)))
                res = word;
        }
        return res;
    }
}
