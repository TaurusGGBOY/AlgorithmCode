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
    TreeNode node;
    TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        node = new TreeNode(root.val);
        temp = node;
        bfs(root);
        return node.right;
    }
    void bfs(TreeNode tn)
    {
        if(tn==null)
            return;
        bfs(tn.left);
        temp.right = new TreeNode(tn.val);
        temp=temp.right;
        bfs(tn.right);
    }
}