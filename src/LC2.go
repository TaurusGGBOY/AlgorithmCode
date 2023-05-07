package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	in := 0
	yummy := &ListNode{-1, nil}
	prev := yummy
	for l1 != nil || l2 != nil {
		l := 0
		r := 0
		if l1 != nil {
			l = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			r = l2.Val
			l2 = l2.Next
		}
		sum := l + r + in
		in = sum / 10
		prev.Next = &ListNode{sum % 10, nil}
		prev = prev.Next
	}
	if in != 0 {
		prev.Next = &ListNode{in, nil}
	}
	return yummy.Next
}
