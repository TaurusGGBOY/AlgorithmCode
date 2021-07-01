import java.util.Comparator;
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
  Vector<Integer> list = new Vector<>();
  int minNum = Integer.MAX_VALUE;
   public int minDiffInBST(TreeNode root) {
        bfs(root);
    set.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    for(int i = 0; i< set.size()-1; i++)
    {
      minNum = Math.min(minNum, Math.abs(set.get(i) - set.get(i+1)));
    }
        return minNum;
    }

    void bfs(TreeNode node)
    {
        if(node==null)
            return;
        set.add(node.val);
        bfs(node.left);
        bfs(node.right);
    }
}