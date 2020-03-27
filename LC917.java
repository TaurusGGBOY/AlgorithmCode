/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//����� �о����ǲ��Ǻܶ�
class Solution {
    int maxHeight = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return maxHeight - 1;
    }

    int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxHeight = Math.max(left + right + 1, maxHeight);
        return Math.max(left, right) + 1;
    }
}