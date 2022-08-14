import java.util.Arrays;

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] forgetNum = new long[n * 3];
        long[] startNum = new long[n * 3];
        long currentRem = 1;
        long currentForget = 0;
        long currentStart = 0;
        long total = 1;
        startNum[1 + delay] = 1;
        forgetNum[1 + forget] = 1;

        long mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            currentForget = (currentForget + forgetNum[i]) % mod;
            currentStart = (currentStart + startNum[i] - forgetNum[i]+ mod) % mod;
            total = (total + currentStart) % mod;
            currentRem = (total + mod - currentForget) % mod;
            startNum[i + delay] = (startNum[i + delay] + currentStart) % mod;
            forgetNum[i + forget] = (forgetNum[i + forget] + currentStart) % mod;
        }
        return (int) currentRem;
    }
}