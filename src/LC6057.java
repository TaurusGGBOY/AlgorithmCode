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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if(root == null) return res;
        int[] temp1 = dfs(root.left);
        int[] temp2 = dfs(root.right);
        res[0] = temp1[0] +  temp2[0] + root.val;
        res[1] = temp1[1] + temp2[1] + 1;
        if(res[0] / res[1] ==  root.val) {
            ans++;
        }
        return res;
    }
}