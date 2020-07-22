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
    public TreeNode pruneTree(TreeNode root) {
        if(hasOne(root)==false)
            return null;
        return root;
    }

    boolean hasOne(TreeNode node)
    {
        if(node==null)
            return false;
        boolean left = hasOne(node.left);
        boolean right = hasOne(node.right);
        if(left==false)
            node.left=null;
        if(right==false)
            node.right=null;
        if(node.val==1||left||right)
            return true;
        return false;
    }
}