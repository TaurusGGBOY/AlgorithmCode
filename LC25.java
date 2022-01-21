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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode yummy = new ListNode(-1, head);
        ListNode pointer = yummy;
        while (true) {
            ListNode prev = pointer;
            int i = 0;
            for (; i < k; i++) {
                if (pointer.next == null) break;
                pointer = pointer.next;
            }
            if (i < k) break;
            ListNode tail = reverse(prev, pointer);
            pointer = tail;
        }
        return yummy.next;
    }

    ListNode reverse(ListNode prev, ListNode tail) {
        ListNode temp = prev.next;
        while (prev.next != tail) insert(tail, prev);
        return temp;
    }

    void insert(ListNode tail, ListNode prev) {
        ListNode node = prev.next;
        prev.next = prev.next.next;
        node.next = tail.next;
        tail.next = node;
    }

}