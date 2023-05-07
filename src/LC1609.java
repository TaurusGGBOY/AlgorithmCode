import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverse(root, true) && traverse(root, false);
    }

    boolean traverse(TreeNode root, boolean odd) {
//        System.out.println();
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (odd) {
            queue.offer(root);
        } else {
            queue.offer(root.left);
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int last = odd ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }

                if (odd && (last >= poll.val || poll.val % 2 == 0)) {
                    return false;
                } else if (!odd && (last <= poll.val || poll.val % 2 == 1)) {
                    return false;
                }
                last = poll.val;
//                System.out.println(last);
                if (poll.left != null) {
                    if (poll.left.left != null) {
                        queue.offer(poll.left.left);
                    }
                    if (poll.left.right != null) {
                        queue.offer(poll.left.right);
                    }
                }
                if (poll.right != null) {
                    if (poll.right.left != null) {
                        queue.offer(poll.right.left);
                    }
                    if (poll.right.right != null) {
                        queue.offer(poll.right.right);
                    }
                }
            }
        }
        return true;
    }
}



