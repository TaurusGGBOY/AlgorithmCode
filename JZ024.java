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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // A->B->C->D->E->null
        // 反转之后
        // E->D->C->B->null
        // 但是A还是有指向尾B的指针
        // A->B->null
        // 插入到B后面 切断环
        // E->D->C->B->A->null
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}