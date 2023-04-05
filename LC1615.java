class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] vis = new int[n][n];
        int[] counter = new int[n];
        for (int[] road : roads) {
            counter[road[0]]++;
            counter[road[1]]++;

            if (road[0] < road[1]) vis[road[0]][road[1]] = 1;
            else vis[road[1]][road[0]] = 1;
        }

        int res = 0;
        for (int i = 0; i < counter.length; i++) {
            for (int j = i + 1; j < counter.length; j++) {
                res = Math.max(counter[i] + counter[j] - vis[i][j], res);
            }
        }
        return res;
    }
}