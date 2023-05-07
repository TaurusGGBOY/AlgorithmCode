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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode yummy = new ListNode(-1, head);
        ListNode tail = yummy;
        for (int i = 0; i < n; i++) tail = tail.next;
        ListNode prev = yummy;
        while (tail.next != null) {
            prev = prev.next;
            tail = tail.next;
        }
        prev.next = prev.next.next;
        return yummy.next;
    }
}