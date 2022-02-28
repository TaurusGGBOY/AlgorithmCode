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
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        int temp = dfs(root, p, q);
        if (res == null && temp == 0) res = root;
        return res;
    }

    int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || res != null) return 0;
        int l = dfs(root.left, p, q);
        int r = dfs(root.right, p, q);
        int m = 0;
        if (root.val == p.val) m = 1;
        else if (root.val == q.val) m = -1;
        int sum = l + r + m;
        if (sum == 0 && (l != 0 || r != 0)) res = root;
        return sum;
    }
}