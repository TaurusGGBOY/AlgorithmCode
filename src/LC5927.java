import java.util.concurrent.CountDownLatch;

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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
//        System.out.println();
        int j = 1;
        while (prev.next != null) {
            int count =0;
            ListNode scan = prev;
            for (int i = 0; i < j && scan.next != null; i++, scan = scan.next) {
                count++;
            }
//            System.out.println(count);
            if (count % 2 == 1) {
                for (int i = 0; i < count && prev.next != null; i++, prev = prev.next) {
                }
            } else {
                reverseNext(prev, count);
                for (int i = 0; i < count && prev.next != null; i++, prev = prev.next) {
                }
            }
            j++;
        }
        return head;
    }

    public void reverseNext(ListNode prev, int k) {
        ListNode head = new ListNode(-1);
        ListNode temp = prev;
        ListNode tail = prev;
        for (int i = 0; i < k && prev.next != null; i++) {
            ListNode node = deleteNextNode(prev);
            if (i == 0) {
                tail = node;
            }
            insertNode(head, node);
        }
        tail.next = prev.next;
        prev.next = head.next;
    }

    public ListNode deleteNextNode(ListNode prev) {
        ListNode node = prev.next;
        prev.next = node.next;
        node.next = null;
        return node;
    }

    public void insertNode(ListNode prev, ListNode node) {
        node.next = prev.next;
        prev.next = node;
    }
}