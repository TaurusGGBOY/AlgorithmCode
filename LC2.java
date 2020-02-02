/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int in = 0;
		ListNode rootListNode = l1;
		while (l1 != null || l2 != null) {
			// System.out.println(in);
			// if (l1 != null && l2 != null) {
			int value = l1.val + l2.val + in;
			in = value / 10;
			l1.val = value % 10;
			if (l1.next == null && l2.next == null)
				break;
			if (l1.next == null)
				l1.next = new ListNode(0);
			if (l2.next == null)
				l2.next = new ListNode(0);
			l1 = l1.next;
			l2 = l2.next;
		}
		if (in != 0)

		{
			// System.out.println(rootListNode.next);
			l1.next = new ListNode(in);
			// System.out.println(rootListNode.next);
		}
// System.out.println(in);
		return rootListNode;
	}
}