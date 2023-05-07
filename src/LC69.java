class Solution {
    public int mySqrt(int x) {
        int r = (int) Math.sqrt(x);
        int l = 0;
        int m = (l + r) / 2;
        while (l < r) {
            if(m * m < x) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return l;
    }
}