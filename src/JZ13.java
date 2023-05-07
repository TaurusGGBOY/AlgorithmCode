class Solution {
    int[][] vis;
    int[][] directions = new int[][]{{0, -1,}, {0, 1}, {1, 0}, {-1, 0}};
    int res;
    int m;
    int n;

    public int movingCount(int m, int n, int k) {
        redVis = new int[m][n];
        res = 0;
        this.m = m;
        this.n = n;
        dfs(0, 0, k);
        return res;
    }

    void dfs(int x, int y, int k) {
        if (x < 0 || y < 0 || x >= m || y >= n || redVis[x][y] == 1) return;
        String str1 = String.valueOf(x);
        String str2 = String.valueOf(y);
        int sum = 0;
        for (int l = 0; l < str1.length(); l++) sum += str1.charAt(l) - '0';
        for (int l = 0; l < str2.length(); l++) sum += str2.charAt(l) - '0';
        if(sum > k) return;
        redVis[x][y] = 1;
        res++;
        for (int[] d : directions) {
            dfs(x + d[0], y + d[1], k);
        }
    }
}