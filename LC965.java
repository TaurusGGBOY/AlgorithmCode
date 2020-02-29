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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return isTree(root.left, root.val) && isTree(root.right, root.val);
    }

    boolean isTree(TreeNode node, int val) {
        if (node == null)
            return true;
        if (val != node.val)
            return false;
        return isTree(node.left, val) && isTree(node.right, val);
    }
}