import java.util.HashMap;
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
    // node 以上 路径为key的个数为value
    static Map<Integer, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        // 相当于还有个0点在root上面
        map.put(0, 1);
        return dfs(root, 0, targetSum);
    }

    // 终点为node的路径总数
    int dfs(TreeNode node, int curr, int targetSum) {
        if (node == null) {
            return 0;
        }
        curr += node.val;
        int res = map.getOrDefault(curr - targetSum, 0);
        map.merge(curr, 1, Integer::sum);
        res += dfs(node.left, curr, targetSum);
        res += dfs(node.right, curr, targetSum);
        map.merge(curr, -1, Integer::sum);
        return res;
    }
}