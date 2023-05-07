package main

func reorderList(head *ListNode) {
	dummy := &ListNode{-1, head}
	slow := dummy
	fast := dummy
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	reverseNext(slow)
	head2 := slow.Next
	slow.Next = nil
	merge(dummy.Next, head2)
}

func insertNext(prev *ListNode, node *ListNode) {
	node.Next = prev.Next
	prev.Next = node
}

func deletNext(prev *ListNode) {
	prev.Next = prev.Next.Next
}

func reverseNext(prev *ListNode) {
	tail := prev.Next
	for tail != nil && tail.Next != nil {
		node := tail.Next
		deletNext(tail)
		insertNext(prev, node)
	}
}

func merge(head1 *ListNode, head2 *ListNode) {
	for head1 != nil && head2 != nil {
		next1 := head1.Next
		next2 := head2.Next
		insertNext(head1, head2)
		head1 = next1
		head2 = next2
	}
}
