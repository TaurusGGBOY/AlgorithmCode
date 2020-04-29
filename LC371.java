import java.math.BigInteger;

class Solution {
    public int getSum(int a, int b) {
        BigInteger abig = new BigInteger(String.valueOf(a));
        BigInteger bbig = new BigInteger(String.valueOf(b));
        return abig.add(bbig).intValue();
    }
}