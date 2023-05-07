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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = new ListNode(0,head);
        ListNode slow = head;
        ListNode first;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 确实是第k个结点
        first = fast;
        // slow是倒数第k个结点
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;
        return head;
    }
}