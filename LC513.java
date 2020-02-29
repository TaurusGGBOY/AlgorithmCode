import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    int left;

    public int findBottomLeftValue(TreeNode root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    left = node.val;
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return left;
    }

    void bfs(TreeNode node) {

    }
}