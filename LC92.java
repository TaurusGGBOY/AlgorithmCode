/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        pre.next = head;
        ListNode preTarget = new ListNode(0);
        ListNode Target = new ListNode(0);
        for (int i = 0; i <= n; i++) {
            ListNode nextNode = temp.next;
            if (i == m - 1) {
                preTarget = temp;
                Target = preTarget.next;
            } else if (i > m && i <= n) {
                Target.next = temp.next;
                temp.next = preTarget.next;
                preTarget.next = temp;
            }
            temp = nextNode;
        }
        return pre.next;
    }
}