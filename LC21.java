/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head;
        if(l1.val < l2.val)
        {    head = new ListNode(l1.val);
            l1=l1.next;
        }
        else
        {
            head = new ListNode(l2.val);
            l2=l2.next;}

        ListNode returnnode = head;

        while(l1!=null||l2!=null)
        {

            if(l1==null)
            {
                ListNode temp = new ListNode(l2.val);
                returnnode.next = temp;
                returnnode =  returnnode.next;
                l2=l2.next;
            }
            else if(l2==null)
            {
                ListNode temp = new ListNode(l1.val);
                returnnode.next = temp;
                returnnode =  returnnode.next;
                l1=l1.next;
            }
            else if(l1.val<l2.val)
            {
                ListNode temp = new ListNode(l1.val);
                returnnode.next = temp;
                returnnode = returnnode.next;
                l1=l1.next;
            }
            else if(l1.val >= l2.val)
            {
                ListNode temp = new ListNode(l2.val);
                returnnode.next = temp;
                returnnode =  returnnode.next;
                l2=l2.next;
            }
        }
        return head;

    }
}