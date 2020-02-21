/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 完全不知道为啥错
class Solution {
    public ListNode getIntersectionNode(int intersectVal, ListNode listA, ListNode listB, int skipA, int skipB) {
            ListNode head1 = listA;
            ListNode head2 = listB;
        while (head1!=head2) {
            head1=head1==null?listB: head1.next;
            head2=head2==null?listA: head2.next;
            try {
                System.out.print(head1.val);
            } catch (Exception e) {
                
            }
            try {
                System.out.println(head2.val);
            } catch (Exception e) {

            }
        }
        return head1;
    }
}