class Solution {
    public int maxProfit(int[] prices) {
        int res = 0,  min = prices[0];
        for (int p : prices) {
            min = Math.min(min, p);
            res = Math.max(p - min, res);
        }
        return res;
    }
}