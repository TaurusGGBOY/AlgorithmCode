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
    static int max;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left < 0 && right < 0) {
            max = Math.max(node.val, max);
            return node.val;
        }
        if (right < 0) {
            max = Math.max(node.val + left, max);
            return node.val + left;
        }
        if (left < 0) {
            max = Math.max(node.val + right, max);
            return node.val + right;
        }
        max = Math.max(node.val + left + right, max);
        return Math.max(left, right) + node.val;
    }
}