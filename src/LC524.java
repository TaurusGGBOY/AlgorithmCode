import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return -a.length() + b.length();
        });
        char[] chars = s.toCharArray();
        for (int l = 0; l < chars.length; l++) {
            for (String s1 : dictionary) {
                char[] chars1 = s1.toCharArray();
                int k = 0;
                for (int r = l; r < chars.length; r++) {
                    if (chars[r] == chars1[k]) {
                        k++;
                    }
                    if (k == chars1.length) {
                        return s1;
                    }
                }
            }
        }
        return "";
    }
}