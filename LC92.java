/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode first = new ListNode(0);
        first.next  = head;
        ListNode start = first;
        for (int i = 0; i < left-1; i++) {
            start = start.next;
        }
        // curr.next指向left
        ListNode curr = start.next;
        // 2. 优化 假如现在curr.next为null会如何 答：不会出现这种情况 一开始curr是2 next是3 然后2 4 然后 2 5反正next都是有实际的值所以即使next.next为null也只有curr.next = null是对的
        for (int i = left; i < right; i++) {
            // 保存要被顶到前面去的老哥
            ListNode next = curr.next;
            // 让现在节点指向他的后方
            curr.next = next.next;
            // 将要顶的节点插入到头部
            ListNode temp = start.next;
            start.next  = next;
            next.next = temp;
        }
        return first.next;
    }
}