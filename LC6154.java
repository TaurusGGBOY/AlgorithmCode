import java.util.HashMap;
import java.util.HashSet;

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
    Map<TreeNode, TreeNode> map;
    Map<Integer, TreeNode> tree;

    Set<Integer> vis;

    int depth;
    int max;

    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        tree = new HashMap<>();
        vis = new HashSet<>();
        depth = 0;
        max = 0;
        build(root);
        dfs(tree.get(start));
        return max - 1;
    }

    void build(TreeNode root) {
        tree.put(root.val, root);
        if (root.left != null) {
            map.put(root.left, root);
            build(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            build(root.right);
        }
    }

    void dfs(TreeNode root) {
        if (vis.contains(root.val)) return;
        vis.add(root.val);
        depth++;
        max = Math.max(depth, max);
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        if (map.get(root) != null) dfs(map.get(root));
        depth--;
    }
}