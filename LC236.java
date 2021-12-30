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
    //    class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        dfs(root, p, q);
        return res;
    }

    int dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left, p, q);
        int r = dfs(node.right, p, q);
        int m = 0;
        if (p == node || q == node) {
            m = 1;
        }
        int sum = l + r + m;
        if (sum == 2 && res == null) {
            res = node;
        }
        return sum;
    }


}
