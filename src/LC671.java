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
    Set<Integer> set;

    public int findSecondMinimumValue(TreeNode root) {
        set = new HashSet<>();
        dfs(root);
        List<Integer> list = new ArrayList<>(set);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        return list.size() < 2 ? -1 : list.get(1);
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}