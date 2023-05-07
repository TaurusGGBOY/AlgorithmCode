import java.math.BigInteger;

class Solution {
    final static int MAXN = 100000;
    public long coutPairs(int[] nums, int k) {
        int[] cnt = new int[MAXN + 1];
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = k / (BigInteger.valueOf(nums[i]).gcd(BigInteger.valueOf(k)).intValue());
            for (int j = 1; j * gcd <= MAXN; j++) cnt[j * gcd]++;
        }
        for (int num : nums) if(1L * num * num <= MAXN && num * num % k ==0) cnt[num]--;
        return res / 2;
    }
}