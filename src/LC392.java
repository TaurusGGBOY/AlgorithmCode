/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return root;
        root.val+=1;
        bstToGst(root.left);
        bstToGst(root.right);
        return root;
    }
}