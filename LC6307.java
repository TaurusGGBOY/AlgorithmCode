class Solution {
    public int passThePillow(int n, int time) {
        time %= 2 * n - 2;
        if (time >= n) return 2 * n - time - 1;
        return time + 1;
    }
}