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
    int[] pre;
    int[] in;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode build(int p_l, int p_r, int i_l, int i_r) {
        if (p_l > p_r) return null;
        TreeNode root = new TreeNode(pre[p_l]);
        int in_root = map.get(pre[p_l]);
        int left_cnt = in_root - i_l;
        int right_cnt = i_r - in_root;
        TreeNode left = build(p_l + 1, p_l + left_cnt, i_l, in_root - 1);
        TreeNode right = build(p_r - right_cnt + 1, p_r, in_root + 1, in_root + right_cnt);
        root.left = left;
        root.right = right;
        return root;
    }
}