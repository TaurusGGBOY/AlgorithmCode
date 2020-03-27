/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int sum = 0;

  public int sumOfLeftLeaves(TreeNode root) {
    bfs(root);
    return sum;
  }

  void bfs(TreeNode node) {
    if (node == null) return;
    if (node.left != null) {
      if (node.left.left == null && node.left.right == null) sum += node.left.val;
    }
    bfs(node.left);
    bfs(node.right);
  }
}
