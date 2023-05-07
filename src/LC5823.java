import java.math.BigInteger;

class Solution {
    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        int time = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(String.valueOf((int)(chars[i] - 'a'+1)));
        }
//        System.out.println(stringBuilder.toString());
        BigInteger sum = new BigInteger(stringBuilder.toString());
        for (; time < k; time++) {
            String str = String.valueOf(sum);
            char[] chars1 = str.toCharArray();
            sum = BigInteger.ZERO;
            for (int kj = 0; kj < chars1.length; kj++) {
                sum = sum.add(new BigInteger(String.valueOf(chars1[kj]-'0')));
            }
        }
        return sum.intValue();
    }
}