import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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
    Map<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        int maxNum=0;
        Vector<Integer> vector = new Vector<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>maxNum)
            {
                vector.clear();
                vector.add(entry.getKey());
                maxNum = entry.getValue();
            }
            else if(entry.getValue()==maxNum)
            {
                vector.add(entry.getKey());
            }
        }
        int[] res = new int[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            res[i] = vector.get(i);
        }
        return res;

    }

    void dfs(TreeNode node)
    {
        if(node==null)
            return;
        map.merge(node.val, 1, (oldval, newval) -> oldval + newval);
        dfs(node.left);
        dfs(node.right);
    }
}