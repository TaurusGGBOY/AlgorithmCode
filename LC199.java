import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    Queue<TreeNode> queue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size-1;i++)
            {
                TreeNode temp = queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            TreeNode temp = queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            list.add(temp.val);
        }
        return list;
    }
}