/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        search(root, val);
        return root;
    }

    public void search(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }
            search(node.left, val);
        }
        if (val > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }
            search(node.right, val);
        }
    }
}