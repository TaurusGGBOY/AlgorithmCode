import java.math.BigInteger;

class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        long NUM = 1000000007;
        long mod =1;
        for (int i = 2; i <= n; i++) {
            String temp = Integer.toBinaryString(i);
            mod = (mod*(long)Math.pow(2,temp.length())+i)%NUM;
        }
        return (int)mod;
    }
}