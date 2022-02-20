/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxPathSum(root *TreeNode) int {

}

func dfs(root * TreeNode) int{
	l := dfs(root.left)
	r := dfs(root.right)
	if l + root.val > r + root.val{
		return l + root.val
}
	else{
		return r + root.val
}
}