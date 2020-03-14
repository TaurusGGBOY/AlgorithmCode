import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        bfs(root1,list1);
        bfs(root2,list2);
        if(list1.size()!=list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)!=list2.get(i))
                return false;
        }
        return true;

    }
    void bfs(TreeNode node, List list)
    {
        if(node==null)
            return;
        if(node.left==null&&node.right==null)
        {
            list.add(node.val);
            return;
        }
        bfs(node.left, list);
        bfs(node.right, list);
    }


}