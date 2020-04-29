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
    int sum=0;
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return sum;
    }

    int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left =dfs(node.left);
        int right =dfs(node.right);
        sum+=Math.abs(left-right);
        return  left+  right + node.val;
    }

}