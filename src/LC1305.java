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

import java.util.*;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return merge(list1, list2);
    }

    void dfs(TreeNode root1, List<Integer> list) {
        if (root1 == null) return;
        dfs(root1.left, list);
        list.add(root1.val);
        dfs(root1.right, list);
    }

    List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        while (l < list1.size() || r < list2.size()) {
            while (l == list1.size() && r < list2.size()) res.add(list2.get(r++));
            while (r == list2.size() && l < list1.size()) res.add(list1.get(l++));
            if (l == list1.size() || r == list2.size()) break;
            if (list1.get(l) < list2.get(r)) res.add(list1.get(l++));
            else res.add(list2.get(r++));
        }
        return res;
    }
}