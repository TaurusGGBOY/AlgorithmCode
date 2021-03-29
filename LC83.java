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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(head.val - 1, head);
        ListNode curr = dummyNode;
        while (curr.next != null && curr.next.next != null) {
            while (curr.next.next != null && curr.next.val == curr.next.next.val) {
                curr.next.next = curr.next.next.next;
            }
            curr = curr.next;
        }
        return dummyNode.next;
    }
}