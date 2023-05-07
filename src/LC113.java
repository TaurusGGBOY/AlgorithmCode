import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    static List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, 0, list);
        return res;
    }

    void dfs(TreeNode node, int sum, int nowSum, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        nowSum += node.val;
        if (nowSum == sum) {
            if (node.left == null && node.right == null)
                res.add(new ArrayList<>(list));
        }
        dfs(node.left, sum, nowSum, list);
        dfs(node.right, sum, nowSum, list);
        list.remove(list.size() - 1);
    }

}