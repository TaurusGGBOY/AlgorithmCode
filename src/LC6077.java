import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int totalStrength(int[] strength) {
        Arrays.sort(strength);
        System.out.println(Arrays.toString(strength));
        int[] sumArr = new int[strength.length + 1];
        long tempSum = 0;
        for (int i = strength.length - 1; i >= 0; i--) {
            tempSum += strength[i];
            tempSum %= 1000000007;
            sumArr[i] = (int) tempSum;
        }
        System.out.println(Arrays.toString(sumArr));
        BigInteger sum = BigInteger.ZERO;
        BigInteger MOD = new BigInteger("1000000007");
        for (int i = 0; i < strength.length - 1; i++) {
            BigInteger poweerTwo = new BigInteger("2");
            sum = poweerTwo
                    .modPow(new BigInteger(String.valueOf(strength.length - i - 2)), MOD)
                    .multiply(new BigInteger(String.valueOf(strength[i])))
                    .mod(MOD)
                    .multiply(new BigInteger(String.valueOf(sumArr[i])).add(new BigInteger(String.valueOf(strength[i]))))
                    .mod(MOD)
                    .add(sum)
                    .mod(MOD);
            System.out.println(sum.intValue());
        }
        sum = sum.add(new BigInteger(String.valueOf(strength[strength.length - 1])).multiply(new BigInteger(String.valueOf(strength[strength.length - 1]))))
                .mod(MOD);
        System.out.println(sum.intValue());
        System.out.println();
        return sum.intValue();

    }
}