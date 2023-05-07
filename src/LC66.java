import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int digit : digits) {
            stringBuilder.append(digit);
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.toString());
        bigInteger = bigInteger.add(BigInteger.ONE);
        char[] chars = bigInteger.toString().toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = chars[i] - '0';
        }
        return res;
    }
}