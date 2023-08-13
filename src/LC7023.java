import java.math.BigInteger;
import java.util.*;

class Solution {
    public int maximumScore(List<Integer> nums, int k) {
        int[] scores = new int[nums.size()];
        long MOD = 1000000007;
//        System.out.println(MOD);
        for (int i = 0; i < scores.length; i++) {
            scores[i] = getScore(nums.get(i));
        }

        System.out.println(Arrays.toString(scores));
        BigInteger[][] dp = new BigInteger[nums.size()][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }

        dp[0][1] = new BigInteger(String.valueOf(nums.get(0)));
        BigInteger res = BigInteger.valueOf((long) nums.get(0));

        int[] maxPair = new int[]{scores[0], 0};

        for (int i = 1; i < nums.size(); i++) {

            if (scores[i] > maxPair[0]) {
                maxPair[0] = scores[i];
                maxPair[1] = i;
            } else if (scores[i] == maxPair[0]) {
                if (nums.get(i) > nums.get(maxPair[1])) {
                    maxPair[1] = i;
                }
            }

            BigInteger temp = BigInteger.valueOf((long) nums.get(maxPair[1]));
            dp[i][1] = temp.max(dp[i - 1][1]);


            for (int j = 2; j <= Math.min(i + 1, k); j++) {

                dp[i][j] = dp[i - 1][j].max((dp[i - 1][j - 1].multiply(BigInteger.valueOf((long) nums.get(maxPair[1])))));
                res = res.max(dp[i][j]);
            }
//            System.out.println(res);
//            System.out.println(maxPair[0] + " " + nums.get(maxPair[1]));
            System.out.println(Arrays.deepToString(dp));

        }
        BigInteger newBigInteger = BigInteger.valueOf((long) 22011);
        newBigInteger = newBigInteger.pow(4);
        newBigInteger = newBigInteger.multiply(BigInteger.valueOf((long) 14858));
        System.out.println(newBigInteger.mod(BigInteger.valueOf((long) MOD)).intValue());

        return res.mod(BigInteger.valueOf(MOD)).intValue();
    }

    private int getScore(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
            while (num % i == 0) {
                num /= i;
            }
        }
        return count;
    }
}