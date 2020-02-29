import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int maxRes = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        getSum(root);

        int left = (root.left == null) ? 1 : map.get(root.left.val);
        int right = (root.right == null) ? 1 : map.get(root.right.val);
        int cancelLeft = left * (root.val + right);
        int cancelRight = right * (root.val + left);
        maxRes = cancelLeft > cancelRight ? cancelLeft : cancelRight;
        testRes(root.left);
        testRes(root.right);
        return maxRes;
    }

    int getSum(TreeNode node) {
        if (node == null)
            return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int res = (int) ((left + right) % (10e9 + 7));
        map.put(node.val, res);
        return res;
    }

    void testRes(TreeNode node) {
        if (node == null)
            return;

        int left = (node.left == null) ? 1 : map.get(node.left.val);
        int right = (node.right == null) ? 1 : map.get(node.right.val);
        int cancelLeft = left * (node.val + right);
        int cancelRight = right * (node.val + left);
        int maxLeftRight = cancelLeft > cancelRight ? cancelLeft : cancelRight;
        maxRes = maxLeftRight > maxRes ? maxLeftRight : maxRes;
    }
}