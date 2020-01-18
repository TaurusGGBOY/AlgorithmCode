class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
// ·ÅÆú

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	TreeNode root = new TreeNode();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		root.val = preorder[0];

		int len = inorder.length;

		int indexInIn = returnIndex(preorder[0], inorder);
		dfs(preorder, inorder, 1, indexInIn, 0, indexInIn - 1, root, 0);
		dfs(preorder, inorder, indexInIn + 1, inorder.length - 1, indexInIn + 1, inorder.length - 1, root, 1);
		return root;
	}

	void dfs(int[] preorder, int[] inorder, int startPre, int endPre, int inStart, int inEnd, TreeNode node, int flag) {

	}

	int returnIndex(int num, int[] order) {
		for (int i = 0; i < order.length; i++)
			if (num == order[i])
				return i;
	}
}