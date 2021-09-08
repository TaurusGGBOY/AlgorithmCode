/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  StringBuilder stringBuilder = new StringBuilder();
  int sum = 0;

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) return 0;
    bfs(root);

    return total;
  }

  void bfs(TreeNode node) {
    if (node == null) return;
    stringBuilder.append(node.val);
    if (node.left == null && node.right == null) {
      total += Integer.parseInt(stringBuilder.toString(), 2);
    }
    bfs(node.left);
    bfs(node.right);
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
  }
}
