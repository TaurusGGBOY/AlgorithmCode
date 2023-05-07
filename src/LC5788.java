import java.math.BigInteger;

class Solution {
    public String largestOddNumber(String num) {
        String res = "";
        char[] chars = num.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            temp.append(c);
            if ((c - '0') % 2 == 1) {
                res = temp.toString();
            }
        }
        return res;
    }
}