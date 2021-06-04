
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = new ListNode(0);
        ListNode tempB = new ListNode(0);
        tempA.next = headA;
        tempB.next = headB;
        int count = 0;
        while (headA != null) {
            headA = headA.next;
            count++;
        }
//        System.out.println("1 "+count);
        while (headB != null) {
            headB = headB.next;
            count--;
        }
//        System.out.println("2 "+count);
        headA = tempB.next;
        headB = tempA.next;
        if (count > 0) {
            while (count-- > 0) {
                headB = headB.next;
            }
        } else {
            while (count++ < 0) {
                headA = headA.next;
            }
        }
        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA == headB ? headA : null;
    }
}