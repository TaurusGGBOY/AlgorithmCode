import java.util.LinkedList;
import java.util.Queue;

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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = 1;
        int rightDepth = 1;
        TreeNode temp = root;
        while (temp.left != null) {
            leftDepth++;
            temp = temp.left;
        }
        while (temp.right != null) {
            rightDepth++;
            temp = temp.right;
        }
        int base = (int) Math.pow(2, rightDepth - 1);
        if (leftDepth == rightDepth) {
            return base;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        base = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            base += len;
            for (int i = 0; i < len; i++) {
               temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return base;

    }
}