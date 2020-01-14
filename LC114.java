import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

	public void flatten(TreeNode root) {
		dfs(root);
		return;
	}

	void dfs(TreeNode node) {
		if (node == null)
			return;
		TreeNode right = node.right;
		TreeNode rightest = getRightest(node.left);
		if (rightest != null) {
			node.right = node.left;
			rightest.right = right;
			node.left = null;
		}
		dfs(node.right);
	}

	TreeNode getRightest(TreeNode node) {
		if (node == null)
			return null;
		TreeNode temp = node;

		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}
}