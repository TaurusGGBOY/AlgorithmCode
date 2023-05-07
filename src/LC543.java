class Solution {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        dfs(root, 0);
        return max;
    }

    int dfs(TreeNode node, int layer) {
        if (node == null) {
            return layer - 1;
        }
        int left = dfs(node.left, layer + 1);
        int right = dfs(node.right, layer + 1);
        max = Math.max(left + right - 2 * layer, max);
//        System.out.println(node.val + " " + layer + " " + left + " " + right + " " + max);
        return Math.max(left, right);
    }
}