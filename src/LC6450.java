class Solution {
    public int minimumSum(int n, int k) {
        int less = Math.min(k / 2, n);
        int sum = 0;
        for (int i = 1; i <= less; i++) {
            sum += i;
        }

        int more = n - less;
        for (int i = k; i < k + more; i++) {
            sum += i;
        }
        return sum;
    }
}