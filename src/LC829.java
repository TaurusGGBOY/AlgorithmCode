class Solution {
    public int consecutiveNumbersSum(int n) {
        int l = 0, r = 1, count = 0;
        long sum = 0;
        while (r <= n / 2) {
            sum += r++;
            if (sum < n) continue;
            while (sum > n && l < r) sum -= l++;
            if (sum == n) count++;
        }
        return count;
    }
}