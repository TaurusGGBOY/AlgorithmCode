package main

import "container/list"

//
//type TreeNode struct {
//	Val   int
//	Left  *TreeNode
//	Right *TreeNode
//}

func zigzagLevelOrder(root *TreeNode) [][]int {
	var res [][]int
	if root == nil {
		return res
	}
	var reverse bool
	reverse = false
	l := list.New()
	l.PushBack(root)

	for l.Len() != 0 {
		len := l.Len()
		temparr := list.New()
		for i := 0; i < len; i++ {
			temp := l.Front()
			temparr.PushBack(temp.Value.(*TreeNode).Val)
			l.Remove(temp)
			if temp.Value.(*TreeNode).Left != nil {
				l.PushBack(temp.Value.(*TreeNode).Left)
			}
			if temp.Value.(*TreeNode).Right != nil {
				l.PushBack(temp.Value.(*TreeNode).Right)
			}
		}
		var arr []int
		if reverse {
			for temparr.Len() > 0 {
				arr = append(arr, temparr.Back().Value.(int))
				temparr.Remove(temparr.Back())
			}

		} else {
			for temparr.Len() > 0 {
				arr = append(arr, temparr.Front().Value.(int))
				temparr.Remove(temparr.Front())
			}
		}
		reverse = !reverse
		res = append(res, arr)
	}
	return res
}
