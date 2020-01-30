import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> integers = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tempNode = queue.poll();
				integers.add(tempNode.val);
				if (tempNode.left != null)
					queue.add(tempNode.left);
				if (tempNode.right != null)
					queue.add(tempNode.right);
			}
			list.add(integers);
		}
		return list;
	}
}