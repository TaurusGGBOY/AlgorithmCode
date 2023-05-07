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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;
        ListNode big = new ListNode(-1);
        ListNode bigHead = big;
        while (head != null) {
//            System.out.println(head.val);
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        // 为什么一定要加这一句？因为 原来big后面可能跟的是个小的 不一定是个null
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}
