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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode yummy = new ListNode(-1);
        ListNode node = yummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.next = list2;
                break;
            }
            if (list2 == null){
                node.next = list1;
                break;
            }
            ListNode temp = null;
            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            node.next = temp;
            node = node.next;
            node.next = null;
        }
        return yummy.next;
    }
}