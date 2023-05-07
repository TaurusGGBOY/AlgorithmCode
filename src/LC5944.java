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
    Map<TreeNode, TreeNode> parents;
    StringBuilder rec;
    StringBuilder res;
    Map<TreeNode, Boolean> vis;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        parents = new HashMap<>();
        parents.put(root, null);
        TreeNode startNode = search(root, startValue);
        setParents(root);
        rec = new StringBuilder();
        res = new StringBuilder();
        redVis = new HashMap<>();
        dfs(startNode, destValue);
        return res.toString();
    }

    TreeNode search(TreeNode node, int startValue) {
        if (node.val == startValue) {
            return node;
        }
        if (node.left != null) {
            TreeNode temp = search(node.left, startValue);
            if (temp != null) {
                return temp;
            }
        }
        if (node.right != null) {
            TreeNode temp = search(node.right, startValue);
            if (temp != null) {
                return temp;
            }
        }
        return null;
    }

    void setParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left, node);
            setParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right, node);
            setParents(node.right);
        }
    }

    void dfs(TreeNode node, int destValue) {
        if (node == null) {
            return;
        }
        if (res.length() != 0) {
            return;
        }
        if(redVis.getOrDefault(node, false)){
            return;
        }
        redVis.put(node, true);
        if (node.val == destValue) {
            res.append(rec);
            redVis.put(node, false);
            return;
        }

        rec.append("U");
        dfs(parents.get(node), destValue);
        rec.deleteCharAt(rec.length() - 1);
        rec.append("L");
        dfs(node.left, destValue);
        rec.deleteCharAt(rec.length() - 1);
        rec.append("R");
        dfs(node.right, destValue);
        rec.deleteCharAt(rec.length() - 1);
        redVis.put(node, false);
    }

}