/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
package main

var minVal int

func closestValue(root *TreeNode, target float64) int {
	minVal = root.Val
	dfs(root, target)
	return minVal
}

func dfs(root *TreeNode, target float64) {
	if root == nil {
		return
	}
	if abs(float64(root.Val)-target) < abs(float64(minVal)-target) {
		minVal = root.Val
	}
	if target < float64(root.Val) {
		dfs(root.Left, target)
	} else {
		dfs(root.Right, target)
	}
}

func abs(num float64) float64 {
	if num < 0 {
		return -num
	}
	return num
}
