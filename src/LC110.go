package main

var res bool

func isBalanced(root *TreeNode) bool {
	res = true
	dfs(root)
	return res
}

func dfs(root *TreeNode) int {
	if root == nil || res == false {
		return 0
	}
	l := dfs(root.Left)
	r := dfs(root.Right)
	if l-r > 1 || r-l > 1 {
		res = false
		return 0
	}
	if l > r {
		return l + 1
	}
	return r + 1
}
