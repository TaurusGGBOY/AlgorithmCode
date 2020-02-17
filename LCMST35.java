import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            temp = new ArrayList<>();


            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null)
                    queue.add(node.right);
            }
            lists.add(temp);
        }
        return lists;
    }
}