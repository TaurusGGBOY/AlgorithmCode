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
    int flag = 0;
    TreeNode temp;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        temp = null;
        bfs(root,p.val,q.val);
        return temp;
    }

    boolean bfs(TreeNode node, int p, int q)
    {
        if(node == null||flag==1)
            return false;
        boolean me = (node.val==q)||(node.val==p);
        boolean left = bfs(node.left,p,q);
        boolean right = bfs(node.right,p,q);
        if((left&&right)||(left&&me)||(right&&me))
        {
            flag=1;
            temp = node;
        }
        return me||left||right;
    }

}