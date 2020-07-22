import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        midSort(root1, list1);
        midSort(root2, list2);
        int i = 0;
        int j = 0;
        if(list1.size()==0)
            return list2;
        if(list2.size()==0)
            return list1;
        while (i != list1.size() || j != list2.size()) {
            if (i == list1.size())
                res.add(list2.get(j++));
            else if (j == list2.size())
                res.add(list1.get(i++));
            else {
                if (list1.get(i) < list2.get(j)) {
                    res.add(list1.get(i++));
                } else {
                    res.add(list2.get(j++));
                }
            }
        }
        return res;
    }

    void midSort(TreeNode node, List<Integer> list) {
        if(node==null)
            return;
        midSort(node.left, list);
        list.add(node.val);
        midSort(node.right, list);
    }
}