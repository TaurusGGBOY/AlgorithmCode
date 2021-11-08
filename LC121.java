class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int price : prices) {
            min = Math.min(price, min);
            res = Math.max(res, price - min);
        }
        return res;
    }
}