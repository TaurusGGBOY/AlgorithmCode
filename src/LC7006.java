import java.util.List;

class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        offers.sort((o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });

        int res = 0;
        int[] dp = new int[n + 1];
        int counter = 0;
        for (List<Integer> offer : offers) {
            int start = offer.get(0);
            int end = offer.get(1);
            int gold = offer.get(2);
            while (counter < start) {
                counter++;
                dp[counter] = Math.max(dp[counter - 1], dp[counter]);
            }
            dp[end + 1] = Math.max(dp[end + 1], dp[start] + gold);
            res = Math.max(dp[end + 1], res);
        }
        return res;
    }
}