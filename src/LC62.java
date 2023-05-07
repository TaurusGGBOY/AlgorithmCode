class Solution {
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        long res = 1;
        int temp = Math.min(m, n);
        for (int i = 0; i < temp; i++) {
            res = res * (m + n - i) / (i+1);
        }
        return (int)res;
    }
}