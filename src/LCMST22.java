/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null)
                return null;
            node = node.next;
        }
        while (node != null) {
            head = head.next;
            node = node.next;
        }
        return head;
    }
}