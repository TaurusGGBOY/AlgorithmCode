import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.pollFirst();
                if(layer%2==1) list.add(poll);
                if(poll.left !=null) deque.offerLast(poll.left);
                if(poll.right !=null) deque.offerLast(poll.right);
            }
            for (int i = 0; i < list.size()/2; i++) {
                int temp = list.get(i).val;
                list.get(i).val = list.get(list.size()-1-i).val;
                list.get(list.size() - 1 - i).val = temp;
            }
            layer++;
        }
        return root;
    }


}