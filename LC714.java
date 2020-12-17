// TODO 失败 好题
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 手上的钱初始为0元 表示手上是否还持有股票
        int hold = -prices[0];
        int empty = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = empty;
            // 如果这次之后不持有
            empty = Math.max(empty, hold + prices[i] - fee);
            // 如果这次之后还是持有
            hold = Math.max(hold, temp - prices[i]);
        }
        return Math.max(empty, hold);
    }
}