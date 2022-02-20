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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null) {
            ListNode first = head;
            int num = first.val;
            head = head.next;
            while(head != null && head.val == num) head = head.next;
            first.next = head;
        }
        return res;
    }
}