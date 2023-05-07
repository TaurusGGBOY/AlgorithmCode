class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        long longestDay = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                longestDay++;
            } else {
                res += (longestDay + 1) * longestDay / 2;
                longestDay = 1;
            }
        }
        res += (longestDay + 1) * longestDay / 2;
        return res;
    }
}
// 1 1
// 2 3
// 3 6[3,2,1,4]
// 4 4+3+2+1=10