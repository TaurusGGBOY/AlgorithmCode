/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode first = new ListNode(-1, null);
        while (head != null) {
            ListNode next = head.next;
            head.next = first.next;
            first.next = head;
            head = next;
        }

        return first.next;
    }
}