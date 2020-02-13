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
	int maxLen=0;
	public int maxDepth(TreeNode root) {
		dfs(root,1);
		return maxLen;
	}

	void dfs(TreeNode node, int len)
	{
		if(node==null)
			return;
		if(len>maxLen)
			maxLen=len;
		dfs(node.left,len+1);
		dfs(node.right,len+1);
	}
}