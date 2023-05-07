class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1;
        // -n会越界
        long m = n;
        if (m < 0) x = 1 / x;
        m = Math.abs(m);

        while (m > 0) {
            if ((m & 1) == 1) res *= x;
            x = x * x;
            m >>= 1;
        }
        return res;
    }
}