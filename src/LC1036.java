class Solution {
    int[][] vis;

    public boolean isEscapePossible(int[][] b, int[] s, int[] t) {
        redVis = new int[(int)1e6+1][1000001];
        return dfs(b, s, t);
    }

    boolean dfs(int[][] b, int[] s, int[] t) {
        if (t[0] == s[0] && t[1] == s[1]) return true;
        if (t[0] < 0 || t[0] >= 1000000 || t[1] < 0 || t[1] >= 10000000) return false;
        redVis[s[0]][s[1]] = 1;
        if (dfs(b, new int[]{s[0] - 1, s[1]}, t)) return true;
        if (dfs(b, new int[]{s[0] + 1, s[1]}, t)) return true;
        if (dfs(b, new int[]{s[0], s[1] - 1}, t)) return true;
        if (dfs(b, new int[]{s[0], s[1] + 1}, t)) return true;
        return false;
    }
}