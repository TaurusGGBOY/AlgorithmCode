import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	int count = 0;

	public int sumEvenGrandparent(TreeNode root) {
		bfs(root);
		return count;
	}

	private void bfs(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;
		if (node.val % 2 == 0) {
			try {
				if (node.left.left != null)
					count += node.left.left.val;
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if (node.left.right != null)
					count += node.left.right.val;
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if (node.right.left != null)
					count += node.right.left.val;
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if (node.right.right != null)
					count += node.right.right.val;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		bfs(node.left);
		bfs(node.right);
	}
}