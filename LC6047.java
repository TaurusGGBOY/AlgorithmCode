import java.math.BigInteger;

class Solution {
    public String removeDigit(String number, char digit) {
        BigInteger max = new BigInteger("-1");
        int flag = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) != digit) continue;
            flag = 1;
            String str = number.substring(0, i) + number.substring(i + 1);
            max = new BigInteger(str).max(max);
        }
        if (flag == 0) return number;
        return max.toString();

    }
}