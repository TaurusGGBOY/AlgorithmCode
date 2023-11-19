import java.math.BigInteger;

class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        BigInteger left = new BigInteger(String.valueOf(a));
        BigInteger right = new BigInteger(String.valueOf(b));

        BigInteger res = left.multiply(right);

        for (int i = 0; i < n; i++) {
            BigInteger bit = new BigInteger(String.valueOf(1L << i));
            BigInteger newLeft = left.xor(bit);
            BigInteger newRight = right.xor(bit);

            BigInteger newProd = newLeft.multiply(newRight);

            if (newProd.compareTo(res) > 0) {
                left = newLeft;
                right = newRight;
                res = newProd;
            }
        }

        BigInteger mod = BigInteger.valueOf(1000000007L);
        res = res.mod(mod);
//        System.out.println(left.toString());
//        System.out.println(right);
        return res.intValue();
    }

}