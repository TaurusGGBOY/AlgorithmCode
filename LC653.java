import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    boolean dfs(TreeNode node ,int k)
    {
        if(node == null)
            return false;
        if(set.contains(k-node.val))
            return true;
        set.add(node.val);
        boolean left = dfs(node.left, k);
        if(left)
            return true;
        boolean right = dfs(node.right, k);
        return right;
    }
}