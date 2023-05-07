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
    static int max;
    static int maxLayer;

    public int maxLevelSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxLayer = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int layer = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
                sum += poll.val;
            }
            if (sum > max) {
                max = sum;
                maxLayer = layer;
            }
            layer++;
        }
        return maxLayer;
    }
}