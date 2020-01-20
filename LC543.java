/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//标记下 感觉还是不是很懂
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