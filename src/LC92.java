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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        left--;
        right--;
        if (left == right) return head;
        ListNode yummy = new ListNode(-1, head);
        ListNode node = yummy;
        for (int i = 0; i < left; i++) node = node.next;
        ListNode prev = node;
        node = node.next;
        for (int i = 0; i < right - left ; i++) {
            ListNode temp = node.next;
            delete(node);
            insert(prev, temp);
        }
        return yummy.next;
    }

    void delete(ListNode prev) {
        prev.next = prev.next.next;
    }

    void insert(ListNode prev, ListNode node) {
        node.next = prev.next;
        prev.next = node;
    }


}