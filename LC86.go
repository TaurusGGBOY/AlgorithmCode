// TODO 失败
package main

import (
	"fmt"
)

/**
* Definition for singly-linked list.
* type ListNode struct {
*     Val int
*     Next *ListNode
* }
*/
func partition(head *ListNode, x int) *ListNode {
	less:=new(ListNode)
	lessPos:=less
	more:=new(ListNode)
	morePos:=more
	res:=new(ListNode)
	resPos:=res
	for head!=nil{
		temp:=head.Next
		if head.Val < x{
			lessPos.Next = head
			lessPos=lessPos.Next
			lessPos.Next = nil
		}else{
			morePos.Next = head
			morePos=morePos.Next
			morePos.Next = nil
		}
		head=temp
	}
	//fmt.Print("get\n")
	for less!=nil{
		//fmt.Print("???\n")
		if less.Next!=nil{
			resPos.Next = less.Next
			resPos=resPos.Next
			less=less.Next
		}else{
			break
		}
	}
	for more!=nil{
		//fmt.Print("ccc\n")
		if more.Next!=nil{
			resPos.Next = more.Next
			resPos=resPos.Next
			more=more.Next
		}else{
			break
		}
	}
	return res.Next
}