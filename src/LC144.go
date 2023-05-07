package main

var res = make([]int, 0)

func preorderTraversal(root *TreeNode) []int {
	res = make([]int, 0)
	dfs(root)
	return res
}

func dfs(root *TreeNode) {
	if root == nil {
		return
	}
	res = append(res, root.Val)
	dfs(root.Left)
	dfs(root.Right)
}
