public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

// 归并失败
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
	public ListNode sortList(ListNode head) {
		// 找到中点
		// 从中点开始?
		ListNode quickNode = head;
		ListNode slowNode = head;
		while (quickNode.next != null) {
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
		}
		ListNode midNode = slowNode;

		ListNode current = head;
		while(current.next)
	}
}