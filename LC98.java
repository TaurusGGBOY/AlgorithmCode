class Solution {
    boolean res;

    public boolean isValidBST(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }

    int[] dfs(TreeNode node) {
        int[] temp = new int[2];
        if (!res) return temp;
        if (node == null) return temp;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[1] >= node.val || right[0] <= node.val) {
            res = false;
            return temp;
        }
        temp[0] = Math.min(node.val, left[1]);
        temp[1] = Math.max(node.val, right[0]);
        return temp;
    }
}