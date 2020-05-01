import java.math.BigInteger;

class Solution {
    public int add(int a, int b) {
        BigInteger a1 = new BigInteger(String.valueOf(a));
        BigInteger b1 = new BigInteger(String.valueOf(b));
        return a1.add(b1).intValue();
    }

}