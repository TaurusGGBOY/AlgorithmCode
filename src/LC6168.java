import java.math.BigInteger;

class Solution {
    final static long MAX = 1000000007;

    public int numberOfWays(int startPos, int endPos, int k) {
        int dis = Math.abs(endPos - startPos);
        if ((k - dis) % 2 == 1) return 0;
        return get(k, dis+(k - dis) / 2);
    }

    int get(int start, int end) {
//        System.out.println("start");
//        System.out.println(start + " " + end);
        BigInteger bigInteger1 = BigInteger.ONE;
        int end1 = start - end;
        while (start > end1) {
            bigInteger1 = bigInteger1.multiply(BigInteger.valueOf(start--));
        }
//        System.out.println(bigInteger1.intValue());
        while (end > 0) {
            bigInteger1 = bigInteger1.divide(BigInteger.valueOf(end--));
        }
        bigInteger1 = bigInteger1.mod(BigInteger.valueOf(MAX));
//        System.out.println(bigInteger1.intValue());
        return bigInteger1.intValue();
    }
}