/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        ListNode node = head;
        ListNode next = node.next;
        while (next.val != val) {
            node = node.next;
            next = next.next;
        }
        node.next = next.next;
        return head;
    }
}