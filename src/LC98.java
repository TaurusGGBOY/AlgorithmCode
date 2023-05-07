import java.util.ArrayList;
import java.util.Arrays;

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
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        isValid = true;
        if (root == null) return true;
        dfs(root);
        return isValid;
    }

    int[] dfs(TreeNode node) {
        int[] minMax = new int[2];
        if (!isValid) return minMax;
        Arrays.fill(minMax, node.val);
        if (node.left != null) {
            int[] res = dfs(node.left);
            if (res[1] >= node.val) {
                isValid = false;
                return minMax;
            }
            minMax[0] = res[0];
        }

        if (node.right != null) {
            int[] res = dfs(node.right);
            if (res[0] <= node.val) {
                isValid = false;
                return minMax;
            }
            minMax[1] = res[1];
        }
        return minMax;
    }
}