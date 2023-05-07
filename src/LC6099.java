
import java.math.BigInteger;

class Solution {
    public int longestSubsequence(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        BigInteger kBig = new BigInteger(String.valueOf(k));
        for (int i = s.length()-1; i >= 0; i--) {
            stringBuilder.insert(0,s.charAt(i));
            BigInteger bigInteger = new BigInteger(stringBuilder.toString(),2);
            if(bigInteger.compareTo(kBig) > 0) {
                stringBuilder.deleteCharAt(0);
            }
        }
        return stringBuilder.length();
    }
}