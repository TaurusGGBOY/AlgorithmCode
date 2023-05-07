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
    boolean flag;
    TreeNode res;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        flag = false;
        res = null;
        dfs(root, p);
        return res;
    }

    void dfs(TreeNode root, TreeNode p) {
        if (null == root || null != res) return;
        dfs(root.left, p);
        if (null != res) return;
        if (flag) {
            res = root;
//            System.out.println(String.format("flag: res:%d", res.val));
        }
        if (root == p) {
            flag = true;
//            System.out.println(String.format("flag: root:%d", root.val));
        }
        dfs(root.right, p);
    }
}