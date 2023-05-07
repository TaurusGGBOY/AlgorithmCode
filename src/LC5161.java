import java.util.Arrays;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");
        int count = 0;
        for (String s1 : s) {
            char[] chars = s1.toCharArray();
            StringBuilder stringBuilder = new StringBuilder(brokenLetters);
            int flag = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (stringBuilder.indexOf(String.valueOf(c)) != -1) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                count++;
        }
        return count;
    }
}