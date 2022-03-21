/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    StringBuilder stringBuilder;
    public String tree2str(TreeNode root) {
        stringBuilder = new StringBuilder();
        dfs(root);
        return stringBuilder.toString();
    }

    void dfs(TreeNode root) {
        if(root == null) return;
        stringBuilder.append(root.val);
        if(root.left == null && root.right != null){
            stringBuilder.append("()(");
            dfs(root.right);
            stringBuilder.append(")");
        } else if (root.left != null && root.right != null) {
            stringBuilder.append("(");
            dfs(root.left);
            stringBuilder.append(")(");
            dfs(root.right);
            stringBuilder.append(")");
        } else if (root.left != null && root.right == null) {
            stringBuilder.append("(");
            dfs(root.left);
            stringBuilder.append(")");
        }else{

        }
    }
}