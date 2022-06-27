import java.math.BigInteger;

class Solution {
    public int countHousePlacements(int n) {
        long f0 = 1;
        long f1 = 1;
        long MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            long temp = f1;
            f1 = (f0 + f1) % MOD;
            f0 = temp % MOD;
        }
        BigInteger bigInteger = BigInteger.valueOf(f1);
        bigInteger = bigInteger.modPow(BigInteger.valueOf(2), BigInteger.valueOf(MOD));
        return bigInteger.intValue();
    }
}