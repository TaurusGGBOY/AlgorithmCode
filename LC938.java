import java.util.Stack;
import java.util.Vector;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	int value = 0;
	int left = 0;
	int right = 0;
	int leftFlag = 0;
	int RightFlag = 0;
	int LV = 0;
	int RV = 0;
	Vector<Integer> stackLeftIntegers = new Vector<Integer>();
	Vector<Integer> stackrightIntegers = new Vector<Integer>();
	Stack<Integer> stack = new Stack<Integer>();

	public int rangeSumBST(TreeNode root, int L, int R) {
		int v = 0;
		LV = L;
		RV = R;
		int last = 0;
		bfs(root);
		for (int i = 0; i < Math.min(stackLeftIntegers.size(), stackrightIntegers.size()); i++) {
			if (stackLeftIntegers.get(i) == stackrightIntegers.get(i) && stackLeftIntegers.get(i) != LV
					&& stackrightIntegers.get(i) != RV) {
				v -= last;
				v += stackLeftIntegers.get(i);
				last = stackLeftIntegers.get(i);
				// v += stackrightIntegers.get(i);
			} else {
				v += stackLeftIntegers.get(i);
				v += stackrightIntegers.get(i);
			}

		}
		return v;
	}

	void bfs(TreeNode node) {
		if (leftFlag == 1 && RightFlag == 1)
			return;
		if (node == null)
			return;
		// value += node.val;
		stack.add(node.val);
		if (node.val == LV) {
			leftFlag = 1;
			stackLeftIntegers.addAll(stack);
		}
		if (node.val == RV) {
			RightFlag = 1;
			stackrightIntegers.addAll(stack);
		}
		bfs(node.left);
		bfs(node.right);
		// value -= node.val;
		stack.pop();
	}
}