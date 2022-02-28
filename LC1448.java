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

    int res;

    public int goodNodes(TreeNode root) {
        res = 0;
        dfs(root, root.val);
        return res;
    }

    void dfs(TreeNode node, int max) {
        if(node == null) return;
        if(max <= node.val){
            res++;
        }
        max = Math.max(node.val, max);
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
