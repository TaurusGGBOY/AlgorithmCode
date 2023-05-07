import java.math.BigInteger;

class Solution {
    public String maximumNumber(String num, int[] change) {
        StringBuilder stringBuilder = new StringBuilder(num);
        char[] chars = num.toCharArray();
        int state = 0;
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i] - '0';
            if (change[n] > n) {
                state = 1;
                stringBuilder.setCharAt(i, (char) (change[n] + '0'));
            } else if (change[n] < n) {
                if (state == 1) {
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}

// "214010"
//[6,7,9,7,4,0,3,4,4,7]
//输出：
//"974010"
//预期：
//"974676"
//"334111"
//        [0,9,2,3,3,2,5,5,5,5]