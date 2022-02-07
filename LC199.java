import java.util.ArrayList;
import java.util.LinkedList;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            res.add(list.getLast().val);
            int n = list.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = list.pollFirst();
                if (node.left != null) list.offerLast(node.left);
                if (node.right != null) list.offerLast(node.right);
            }
        }
        return res;
    }
}