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
    StringBuilder stringBuilder;
    int sum;
    public int sumNumbers(TreeNode root) {
        stringBuilder = new StringBuilder();
        total =0 ;
        dfs(root);
        return total;
    }
    public void dfs(TreeNode node)
    {
        if(node == null)
            return;
        stringBuilder.append(node.val);
        if(node.left==null&&node.right==null)
        {
            total += Integer.parseInt(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }
        dfs(node.left);
        dfs(node.right);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}