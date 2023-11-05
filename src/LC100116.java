class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] win = new int[n];

        for (int i = 0; i < edges.length; i++) {
            ++win[edges[i][1]];
        }

        int res = -1;
        for (int i = 0; i < win.length; i++) {
            if (win[i] == 0) {
                if (res == -1) {
                    res = i;
                } else {
                    return -1;
                }
            }
        }
        return res;
    }
}