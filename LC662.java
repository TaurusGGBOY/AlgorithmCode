import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

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
    Map<Integer, Integer> map;

    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        return dfs(root, 0, 0);
    }

    int dfs(TreeNode node, int d, int i) {
        if (node == null) return 0;
        map.putIfAbsent(d, i);
        int l = dfs(node.left, d + 1, i * 2);
        int r = dfs(node.right, d + 1, i * 2 + 1);
        return Math.max(i - map.get(d) + 1, Math.max(l, r));
    }
}