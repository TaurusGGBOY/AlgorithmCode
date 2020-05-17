import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<Integer> set = new HashSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if(set.size()<=1)
            return -1;
        Vector<Integer> vector = new Vector<>(set);
        vector.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return vector.get(1);
    }
    void dfs(TreeNode node){
        if (node == null) {
            return;
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}