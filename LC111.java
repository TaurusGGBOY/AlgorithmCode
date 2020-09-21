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
    static int res;
    public int minDepth(TreeNode root) {
        res = Integer.MAX_VALUE;
        if(root==null)
            return 0;
        minDepth(root,0);
        return res;
    }

    public void minDepth(TreeNode root, int deep) {
        if(root==null)
            return;
        deep++;
//        System.out.println(deep);
        if(root.left==null&&root.right==null)
        {
            res=Math.min(deep,res);
        }
        else
        {
            minDepth(root.left,deep);
            minDepth(root.right,deep);
        }
    }
}