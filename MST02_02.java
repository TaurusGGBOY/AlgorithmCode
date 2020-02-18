/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode node =head;
        for (int i = 0; i < k; i++) {
            node=node.next;
        }
        while (node!= null) {
            node=node.next;
            head=head.next;
        }
        return head.val;
    }
}