/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        if (node.next == null)
            node = null;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}