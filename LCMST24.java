/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode next;
        ListNode rear = head;
        if ((next = head.next) == null)
            return head;
        while (next != null) {
            // print(head);
            if (next == null)
                break;
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
            rear.next = temp;

        }
        return head;
    }

    void print(ListNode node) {
        try {
            while (node != null) {
                System.out.print(node.val);
                node = node.next;
            }
        } catch (Exception e) {
            System.out.print("wrong");
        }
        System.out.println();
    }
}