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
    TreeNode root;

    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        return dfs(root, k);
    }

    TreeNode find(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        if (target < root.val) return find(root.left, target);
        if (target > root.val) return find(root.right, target);
        return null;
    }

    boolean dfs(TreeNode node, int k) {
        if (node == null) return false;
        TreeNode temp = find(root, k - node.val);
        if (temp!= null && temp != node) return true;
        boolean temp1 = dfs(node.left, k);
        boolean temp2 = dfs(node.right, k);
        return temp1 || temp2;
    }
}