import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode yummy = new ListNode(-1);
        ListNode curr = yummy;
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) if(list != null ) queue.offer(list);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = node;
            if (node.next != null) queue.offer(node.next);
        }
        return yummy.next;
    }
}