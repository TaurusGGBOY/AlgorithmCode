import java.util.Vector;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// �����Լ�֦
class Solution {
    Vector<TreeNode> set1 = new Vector<>();
    Vector<TreeNode> set2 = new Vector<>();
    Vector<TreeNode> set = new Vector<>();
    int pVal = 0;
    int qVal = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pVal = p.val;
        qVal = q.val;
        dfs(root);
        TreeNode nodeNum = new TreeNode(0);
        int deep = 0;
        for (int i = set1.size() - 1; i >= 0; i--) {
            if (set2.contains(set1.get(i))) {
                nodeNum = set1.get(i);
                deep = i;
                break;
            }
        }
        for (int i = set2.size() - 1; i >= 0; i--) {
            if (set1.contains(set2.get(i)) && i > deep) {
                nodeNum = set2.get(i);
                break;
            }
        }
        return nodeNum;
    }

    void dfs(TreeNode node) {
        if (node == null)
            return;
        set.add(node);
        if (node.val == pVal) {
            set1.addAll(set);
        }
        if (node.val == qVal) {
            set2.addAll(set);
        }
        dfs(node.left);
        dfs(node.right);
        set.remove(set.size() - 1);
    }
}