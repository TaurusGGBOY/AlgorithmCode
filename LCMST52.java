/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null)
			return null;
		if(headB==null)
			return null;
		ListNode node1=headA;
		ListNode node2= headB;
		while(headA!=headB)
		{
			headA=headA.next;
			headB=headB.next;
			if(headA==headB)
				return headA;
			if(headA==null)
				headA=node1;
			if(headB==null)
				headB=node2;
		}
		return headA;

	}
}