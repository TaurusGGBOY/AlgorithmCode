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
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0,head);
        ListNode prev = first;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            }else{
                head = head.next;
                prev = prev.next;
            }
        }
        return first.next;
    }
}