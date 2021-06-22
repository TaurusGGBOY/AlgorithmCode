/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class JZ38 {
    public ListNode removeDuplicateNodes(ListNode head) {
        int[] a = new int[20001];
        if (head == null)
            return null;
        ListNode temp = head.next;
        ListNode pre = head;
        a[pre.val]++;
        while (temp != null) {
            if (a[temp.val] != 0) {
                pre.next = temp.next;
                temp = temp.next;
                continue;
            }
            a[temp.val]++;
            pre = pre.next;
            temp = temp.next;
        }
        return head;
    }
}