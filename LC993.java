
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    Map<Integer, Integer> map = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        bfs(root,x,y,root.val,1);
        if(map.size()==2)
        {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> entry1 = iterator.next();
            Map.Entry<Integer, Integer> entry2 = iterator.next();
            return entry1.getKey()!=entry2.getKey()&&entry1.getValue()==entry2.getValue();
        }
        return false;
    }
    void bfs(TreeNode root, int x ,int y,int father,int depth)
    {
        if(root==null)
            return;
        if(root.val==x||root.val==y)
            map.put(father,depth);
        bfs(root.left,x,y,root.val,depth+1);
        bfs(root.right,x,y,root.val,depth+1);
    }
}