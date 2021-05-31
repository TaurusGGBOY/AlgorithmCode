class Solution {
    public boolean isPowerOfFour(int n) {
        if (Integer.bitCount(n)==1) {
            while (n > 0) {
                if (n == 1) {
                    return true;
                }
                n = n >> 2;
            }
        }
        return false;
    }
}