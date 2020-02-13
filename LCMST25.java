/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummyNode = new ListNode(0);
		ListNode newList = dummyNode;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				dummyNode.next = l1;
				l1 = l1.next;
			} else {
				dummyNode.next = l2;
				l2 = l2.next;
			}
			dummyNode = dummyNode.next;
		}

		if (l1 != null)
			dummyNode.next = l1;
		if (l2 != null)
			dummyNode.next = l2;
		return newList.next;
	}
}
