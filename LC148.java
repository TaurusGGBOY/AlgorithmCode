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
// TODO 1. 优化变量名 看能否有其他优化空间 2. 要一个不能交换值的写法 3. 写归并
class Solution {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
    void quickSort(ListNode l, ListNode r) {
        if(l == r || l.next == r) return;
        ListNode m = partition(l, r);
        quickSort(l, m);
        if(m != null) quickSort(m.next, r);
    }
    ListNode partition(ListNode l, ListNode r) {
        ListNode slow = l;
        while (slow.next != r && slow.next.val <= l.val) slow = slow.next;
        ListNode fast = slow.next;
        while (fast != r) {
            while (slow.next != r && slow.next.val <= l.val) slow = slow.next;
            while (fast != r && fast.val >= l.val) fast = fast.next;
            if(fast != r) swap(slow.next, fast);
        }
        swap(slow, l);
        return slow;
    }
    void swap(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
