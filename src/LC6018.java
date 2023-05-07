import java.text.BreakIterator;
import java.util.*;

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
    Map<Integer, int[]> revertMap;

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> allSet = new HashSet<>();
        revertMap = new HashMap<>();
        for (int[] d : descriptions) {
            allSet.add(d[0]);
            inDegree.merge(d[1], 1, Integer::sum);
            int[] nodes;
            if (!revertMap.containsKey(d[0])) {
                nodes = new int[2];
                Arrays.fill(nodes, Integer.MIN_VALUE);
            } else {
                nodes = revertMap.get(d[0]);
            }
            nodes[d[2]] = d[1];
            revertMap.put(d[0], nodes);
        }
        TreeNode root = null;
        for (int integer : allSet) {
            if (!inDegree.containsKey(integer)) {
                root = new TreeNode(integer);
                break;
            }
        }
        build(root);
        return root;
    }

    private void build(TreeNode root) {
        if (root == null) return;
        if (!revertMap.containsKey(root.val)) return;
        int[] nodes = revertMap.get(root.val);
        if (nodes[0] != Integer.MIN_VALUE) {
            root.right = new TreeNode(nodes[0]);
        }
        if (nodes[1] != Integer.MIN_VALUE) {
            root.left = new TreeNode(nodes[1]);
        }
        build(root.left);
        build(root.right);
    }
}