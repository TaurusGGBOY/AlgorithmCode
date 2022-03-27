class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        if (n == 0) return 0;
        int mod = n % 10;
        int next = n - 10;
        if (mod == 0) {
            count++;
            while (mod == 0) {
                mod = n % 10;

                count++;
            }
        } else if (mod >= 5) count++;
        return count + trailingZeroes(next);
    }
}