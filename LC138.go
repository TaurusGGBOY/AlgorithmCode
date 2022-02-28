/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */
package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	vis := make(map[*Node]*Node)
	first := Node{Val: head.Val}
	temp := first
	for head != nil {
		temp = temp.Next
		head = head.Next
		temp.Next = make(map)
	}
}
