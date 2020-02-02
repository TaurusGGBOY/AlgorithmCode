import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
	int sum = 0;
	int singleSum = 0;

	public int rob(TreeNode root) {

		int[] result = dfs(root);
		return Math.max(result[0], result[1]);
	}

	int[] dfs(TreeNode node) {
		int[] result = new int[2];
		if (node == null)
			return result;

		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = left[0] + right[0] + node.val;
		return result;
	}
}