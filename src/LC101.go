/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
	return dfs(root.Left, root.Right)
}

func dfs(left *TreeNode, right *TreeNode) bool{
	if left == nil && right == nil {return true}
	if left == nil || right == nil {return false}
	return left.Val == right.Val && dfs(left.Left, right.Right) && dfs(left.Right, right.Left)
}