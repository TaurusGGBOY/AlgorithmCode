package main

import "fmt"

func sortList(head *ListNode) *ListNode {
	return merge(head, nil)
}

func merge(head *ListNode, tail *ListNode) *ListNode {
	if head == tail || head.Next == tail {
		return head
	}
	slow := head
	fast := head.Next
	for fast != tail && fast.Next != tail {
		slow = slow.Next
		fast = fast.Next.Next
	}
	head2 := slow.Next
	slow.Next = nil
	l := merge(head, nil)
	r := merge(head2, tail)
	yummy := &ListNode{-1, nil}
	temp := yummy
	for l != nil || r != nil {
		if l == nil {
			temp.Next = r
			break
		}
		if r == nil {
			temp.Next = l
			break
		}
		if l.Val < r.Val {
			temp.Next = l
			l = l.Next
		} else {
			temp.Next = r
			r = r.Next
		}
		temp = temp.Next
	}
	return yummy.Next
}

func insert(prev *ListNode, node *ListNode) {
	node.Next = prev.Next
	prev.Next = node
}

func toString(head *ListNode) {
	for head != nil {
		fmt.Print(head.Val)
		head = head.Next
	}
	fmt.Println()
}
