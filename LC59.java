class Solution {
    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int max = Math.max(Math.max(l + root.val, r + root.val), root.val);
        res = Math.max(Math.max(res, max), l + r + root.val);
        return max;
    }
}