class Solution {
    public boolean hasAlternatingBits(int n) {
        int start = n & 1;
        while (n != 0) {
            if (start != (n & 1)) return false;
            start = (~start) & 1;
            n >>= 1;
        }
        return true;
    }
}