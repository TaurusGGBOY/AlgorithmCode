import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	int nums = 0;
	int lastSum = 0;
	Vector<Integer> vector = new Vector<>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	// TODO Auto-generated constructor stub
	public TreeNode convertBST(TreeNode root) {
		search(root);
		vector.sort(new IntergerComparator());
		lastSum = 0;
		for (int i = 0; i < vector.size(); i++) {
			lastSum += vector.get(i);
			map.put(vector.get(i), lastSum);
			// System.out.println(lastSum);

		}
		change(root);
		return root;
	}

	public void search(TreeNode node) {
		if (node == null)
			return;
		vector.add(node.val);
		search(node.left);
		search(node.right);
	}

	public void change(TreeNode node) {
		if (node == null)
			return;
		node.val = map.get(node.val);
		change(node.left);
		change(node.right);
	}

	static class IntergerComparator implements Comparator<Integer> {
		public int compare(Integer a1, Integer a2) {
			return -a1 + a2;
		}
	}

}
