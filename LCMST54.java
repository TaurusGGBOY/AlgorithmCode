import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<Integer> stack = new Stack<>();

    public int kthLargest(TreeNode root, int k) {
        bfs(root);
        int temp;
        for (int i = 0; i < k - 1; i++) {
            temp = stack.pop();
            //System.out.println(temp);
        }
        return stack.pop();
    }

    void bfs(TreeNode node) {
        if (node == null)
            return;
        bfs(node.left);
        stack.add(node.val);
        bfs(node.right);

    }
}