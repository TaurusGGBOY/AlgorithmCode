import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// ·ÅÆú
class Solution {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		int mid = findPos(preorder[0], inorder);
		// System.out.println(mid);
		TreeNode root = new TreeNode(preorder[0]);
		dfs(preorder, inorder, 0, mid - 1, root.left, 1, 1);
		dfs(preorder, inorder, mid + 1, preorder.length - 1, root.right, 2, 4);
		return root;
	}

	void dfs(int[] preorder, int[] inorder, int start, int end, TreeNode node, int preStart, int preEnd) {
		if (start > end)
			return;
		// System.out.println(start);
		if (preStart >= preorder.length)
			return;

		int mid = findPos(preorder[preStart], inorder);
		node = new TreeNode(preorder[preStart]);
		System.out.println(preorder[preStart]);
		if (start == end)
			return;
		dfs(preorder, inorder, start, mid - 1, node.left, preStart + 1, preStart + 1 + mid - start);
		dfs(preorder, inorder, mid + 1, end, node.right, preStart + 1 + mid - start + 1, preEnd);
	}

	int findPos(int val, int[] order) {
		for (int i = 0; i < order.length; i++)
			if (order[i] == val)
				return i;
		return 0;
	}
}