import java.util.*;

class Solution {
//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 考点1：循环有两个条件
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            // 考点2 直接就修改root就行
            root = stack.pollLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}