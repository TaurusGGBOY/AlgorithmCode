class Solution {
    int[] post;

    public boolean verifyPostorder(int[] postorder) {
        post = postorder;
        return dfs(0, postorder.length - 1);
    }

    boolean dfs(int l, int r) {
        if (l >= r) return true;
        Map<Integer, Integer>
        int m = l;
        while (post[m] < post[r]) m++;
        int n = m;
        while (post[m] > post[r]) m++;
        return m == r && dfs(l, n - 1) && dfs(n, r - 1);
    }
}