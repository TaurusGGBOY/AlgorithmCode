import java.util.*;

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
    int[] pre;
    int[] in;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(0, pre.length - 1, 0);
    }

    // l:中序左端点 r：中序右端点 m：前序头结点
    TreeNode build(int l, int r, int m) {
        if (l > r) return null;
        int mid = map.get(pre[m]);
        TreeNode left = build(l, mid - 1, m + 1);
        TreeNode right = build(mid + 1, r, m + 1 + mid - l);
        TreeNode root = new TreeNode(pre[m]);
        root.left = left;
        root.right = right;
        return root;
    }
}