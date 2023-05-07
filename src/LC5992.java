class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int max = 0;
        next:
        for (int i = 0; i < 1 << n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) continue;
                for (int k = 0; k < n; k++)
                    if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) continue next;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}