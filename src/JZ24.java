/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode node =  head.next;
            head.next = node.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}