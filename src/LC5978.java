import java.util.HashSet;
import java.util.Set;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set = new HashSet<>();
        for (String s : startWords) {
            char[] chars = s.toCharArray();
            int[] count = new int[26];
            for (char c : chars) {
                count[c - 'a']++;
            }
            String res = arrayToStr(count);
            set.add(res);
        }
        int ans = 0;
        for (String s : targetWords) {
            char[] chars = s.toCharArray();
            int[] count = new int[26];
            for (char c : chars) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] == 1) {
                    count[i] = 0;
                    String res = arrayToStr(count);
                    if (set.contains(res)) {
                        ans++;
                        break;
                    }
                    count[i] = 1;
                }
            }
        }
        return ans;
    }

    String arrayToStr(int[] count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : count) {
            StringBuilder s = new StringBuilder(String.valueOf(i));
            stringBuilder.append(s);
        }
//        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}