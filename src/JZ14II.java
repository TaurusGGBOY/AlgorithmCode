class Solution {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        long res = 1;
        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int) ((res * n) % 1000000007);
    }
}