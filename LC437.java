/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	int nums = 0;
	int disSum = 0;
	int height = 0;
	int[] nodeVal = new int[1000];
	int temp = 0;

	public int pathSum(TreeNode root, int sum) {
		disSum = sum;
		dfs(root);
		return nums;
	}

	void dfs(TreeNode node) {
		if (node == null)
			return;
		temp = node.val;
		if (temp == disSum)
			nums++;
		for (int i = height - 1; i >= 0; i--) {
			temp += nodeVal[i];
			if (temp == disSum)
				nums++;
		}
		nodeVal[height] = node.val;
		height++;
		dfs(node.left);
		dfs(node.right);
		height--;
	}
}