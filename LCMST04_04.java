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
        public boolean isBalance =true;
        public boolean isBalanced(TreeNode root) {
            if(root==null)
                return true;
            int left =getDepth(root.left);
            int right=getDepth(root.right);
            if(!isBalance)
                return isBalance;
            return Math.abs(left-right)<=1;
        }
        int getDepth(TreeNode node)
        {
            if(!isBalance)
                return 0;
            if(node==null)
                return 0;
            int left =getDepth(node.left)+1;
            int right=getDepth(node.right)+1;
            if(Math.abs(left-right)>1)
                isBalance = false;
            return Math.max(left, right);
        }
    }