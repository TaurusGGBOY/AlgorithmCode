import java.util.Arrays;

class Solution {
    public String modifyString(String s) {
        s = "a" + s + "a";
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '?') {
                chars[i] = (char)((chars[i - 1] - 'a' + 1) % 26 + 'a');
                if (chars[i] == chars[i + 1]) {
                    chars[i] = (char)((chars[i] - 'a' + 1) % 26 + 'a');
                }
            }
        }
        return new String(Arrays.copyOfRange(chars, 1, chars.length - 1));
    }
}