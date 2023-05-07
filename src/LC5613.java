class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxRes = 0;
        for (int[] account : accounts) {
            int temp  =0;
            for (int i : account) {
                temp += i;
            }
            maxRes = Math.max(temp, maxRes);
        }
        return maxRes;
    }
}