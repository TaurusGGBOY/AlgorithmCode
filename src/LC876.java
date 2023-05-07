/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode low = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null)
        {
            low = low.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            low=low.next;
        return low;
    }
}