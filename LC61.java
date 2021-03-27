/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode prev = dummyNode;
        int len = 0;
        while (prev.next != null) {
            prev = prev.next;
            len++;
        }
        ListNode last = prev;
        k = k % len;
        prev = dummyNode;
        for (int i = 0; i < len - k; i++) {
            prev = prev.next;
        }
        last.next = dummyNode.next;
        dummyNode.next = prev.next;
        prev.next = null;
        return dummyNode.next;
    }
}