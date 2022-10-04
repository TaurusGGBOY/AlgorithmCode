import java.util.Arrays;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount1 = Integer.bitCount(num2);

        System.out.println(bitCount1);
        int[] alpha = new int[32];
        int[] res = new int[32];
        int temp = num1;
        for (int i = 0; i < alpha.length && temp != 0; i++, temp >>= 1) alpha[i] = temp & 1;
        for (int i = alpha.length - 1; i >= 0 && bitCount1 > 0; i--) {
            if (alpha[i] == 1) {
                res[i] = 1;
                bitCount1--;
            }
        }
        for (int i = 0; i < alpha.length && bitCount1 > 0; i++) {
            if (res[i] == 0) {
                res[i] = 1;
                bitCount1--;
            }
        }
//        System.out.println(Arrays.toString(alpha));
//        System.out.println(Arrays.toString(res));
//        System.out.println();
        int ans = 0;
        for (int i = 0; i < res.length; i++) {
            if(res[i] == 1) ans += 1 << i;
        }
        return ans;
    }
}