/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode target;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        target = null;
        dfs(root, p, q);
        return target;
    }

    int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || target != null) return 0;
        int l = dfs(root.left, p, q);
        int r = dfs(root.right, p, q);
        int m = root == p ? 1 : 0;
        m = root == q ? -1 : m;
        if ((l != 0 || r != 0) && (l + r + m) == 0) target = root;
        return l + r + m;
    }
}