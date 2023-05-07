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
    static int depth =0;
    static int max=0;
    public int maxDepth(TreeNode root) {
        depth=0;
        max=0;
        dfs(root);
        return max;
    }
    void dfs(TreeNode root)
    {
        if(root==null)
            return;
        depth++;
        max = Math.max(depth, max);
        dfs(root.left);
        dfs(root.right);
        depth--;
    }

}