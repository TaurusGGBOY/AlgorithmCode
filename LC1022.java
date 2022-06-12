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
    int res;
    public int sumRootToLeaf(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int grade) {
        if(root == null) return;
        grade = grade * 2 + root.val;
        if(root.left == null && root.right == null){
            res += grade;
            return;
        }
        dfs(root.left,grade);
        dfs(root.right,grade);
    }
}