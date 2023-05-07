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
    int count;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = -1;
        dfs(root, k);
        return ans;
    }

    void dfs(TreeNode node, int k) {
        if (node == null || ans != -1) {
            return;
        }
        dfs(node.left, k);
        count++;
        if (count == k) {
            ans = node.val;
            return;
        }
        dfs(node.right, k);
    }
}