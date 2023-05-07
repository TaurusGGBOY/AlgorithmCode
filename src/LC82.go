package main

//type ListNode struct {
//	Val  int
//	Next *ListNode
//}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
	prev := &ListNode{Val: -1, Next: head}
	first := prev

	for first.Next != nil {
		if first.Next == nil || first.Next.Next == nil || first.Next.Val != first.Next.Next.Val {
			first = first.Next
			continue
		}
		tempVal := first.Next.Val
		tempNode := first.Next
		for tempNode != nil && tempNode.Val == tempVal {
			tempNode = tempNode.Next
		}
		first.Next = tempNode
	}
	return prev.Next
}
