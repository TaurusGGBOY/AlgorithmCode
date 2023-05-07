class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] sum = new int[cardPoints.length];
        sum[0] = cardPoints[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = cardPoints[i] + sum[i - 1];
        }
        int max = sum[sum.length - 1];

        int remind = cardPoints.length - k;
        if(remind==0)
            return sum[sum.length - 1];
        int res = max - sum[remind - 1];
        for (int i = remind; i < sum.length; i++) {
            res = Math.max(res, max - (sum[i] - sum[i - remind]));
        }
        return res;
    }
}