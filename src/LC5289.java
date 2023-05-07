class Solution {
    int res;

    public int distributeCookies(int[] cookies, int k) {
        res = Integer.MAX_VALUE;
        dfs(cookies, 0, k, new int[k]);
        return res;
    }

    void dfs(int[] cookies, int pos, int k, int[] owns) {
        if (pos == cookies.length) {
            int max = owns[0];
            for (int i = 0; i < owns.length; i++) {
                if (owns[i] == 0) return;
                max = Math.max(owns[i], max);
            }
            res = Math.min(res, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            owns[i] += cookies[pos];
            dfs(cookies, pos + 1, k, owns);
            owns[i] -= cookies[pos];
        }
    }
}