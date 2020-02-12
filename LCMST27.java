import javax.swing.tree.TreeNode;
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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
		TreeNode node;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++){
                node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null)
                queue.add(node.right);
            TreeNode temp = node.left;
            node.left =node .right;
            node.right=temp;}
        }
        return root;
    }
}