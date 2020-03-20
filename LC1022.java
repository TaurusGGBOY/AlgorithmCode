/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  StringBuilder stringBuilder = new StringBuilder();
  int sum = 0;

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    bfs(root, 1);

    return sum;
  }

  void bfs(TreeNode node, int num) {
    if (node == null) return;
    stringBuilder.append(num);
    if (node.left == null && node.right == null) {
      sum += Integer.parseInt(stringBuilder.toString(), 2);
    }
    bfs(node.left, 0);
    bfs(node.right, 1);
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
  }
}
