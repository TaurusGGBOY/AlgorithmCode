///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public ListNode insertionSortList(ListNode head) {
//        ListNode first = new ListNode(0);
//        ListNode prev = first;
//        first.next = head;
//        ListNode temp = first;
//        while (temp != null) {
//            prev = first;
//            ListNode next = temp.next;
//            head = first.next;
//            while(head.next!=next)
//            {
//                if(head.next==null)
//                {
//
//                }
//            }
//            temp=next;
//        }
//
//    }
//}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode beforeCurrent = head;
//        System.out.println("一次");
        while (beforeCurrent.next != null) {
            if (beforeCurrent.val <= beforeCurrent.next.val) {
                beforeCurrent = beforeCurrent.next;
                continue;
            }
            ListNode prev = first;
            // 插入在 prev和prev.next中间的操作
            while (prev.next.val <= beforeCurrent.next.val) {
//                System.out.println(prev.next.val);
                prev = prev.next;
            }
            // 断开current
            ListNode temp = beforeCurrent.next;
            beforeCurrent.next = beforeCurrent.next.next;

            // 插入到prev后面
            temp.next = prev.next;
            prev.next = temp;
        }
        return first.next;
    }
}