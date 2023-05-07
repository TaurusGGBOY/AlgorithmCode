class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        double base = x;
        long index = n;

        if (n < 0) {
            base = 1 / x;
            index = -index;
        }

        while (index > 0) {
            if ((index & 1) == 1) {
                res *= base;
            }
            base *= base;
            index = index >> 1;
        }
        return res;
    }
}