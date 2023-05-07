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

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        l = Math.max(l, 0);
        r = Math.max(r, 0);
        max = Math.max(l + r + node.val, max);
        return Math.max(l + node.val, r + node.val);
    }
}