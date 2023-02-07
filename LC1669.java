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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode yummy = new ListNode();
        int index1 = 0;
        yummy.next = list1;
        ListNode temp = yummy;
        while (index1++ != a) temp = temp.next;
        // 复用list1
        list1 = temp.next;
        temp.next = list2;
        while (list2.next != null) list2 = list2.next;

        while (index1++ <= b) list1 = list1.next;
        list2.next = list1.next;
        return yummy.next;

    }
}