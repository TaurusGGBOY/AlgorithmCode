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
    boolean res;

    public boolean isBalanced(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }

    int dfs(TreeNode root) {
        if (!res) return 0;
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (Math.abs(l - r) > 1) res = false;
        return Math.max(l, r) + 1;
    }
}