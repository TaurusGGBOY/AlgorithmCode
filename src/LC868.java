class Solution {
    public int binaryGap(int n) {
        int temp = 0;
        int res = 0;
        while (n != 0 && (n & 1) == 0) {
            n >>= 1;
            temp++;
        }
        int lo = temp;

        while (n != 0) {
            if (((n & 1) == 1)) {
                res = Math.max(temp - lo, res);
                lo = temp;
            }
            temp++;
            n >>= 1;
        }
        return res;
    }
}