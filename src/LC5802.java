import java.math.BigInteger;

class Solution {
    public int countGoodNumbers(long n) {
        long ji = n/2;
        long ou = n - ji;
        BigInteger five = new BigInteger("5");
        BigInteger zhi = new BigInteger("4");
        BigInteger mod = new BigInteger("1000000007");
        BigInteger fivePow = five.modPow(new BigInteger(String.valueOf(ou)), mod);
        BigInteger zhiPow = zhi.modPow(new BigInteger(String.valueOf(ji)), mod);
        BigInteger res = fivePow.multiply(zhiPow).mod(mod);
        return res.intValue();
    }
}