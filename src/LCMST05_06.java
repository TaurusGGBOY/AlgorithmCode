import java.math.BigInteger;

class Solution {
    public int convertInteger(int A, int B) {
        int temp = A^B;
        return Integer.bitCount(temp);
    }
}