import java.lang.invoke.CallSite;
import java.util.PriorityQueue;
import java.util.Queue;

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
//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> lists[o1].val - lists[o2].val);
        for (int i = 0; i < lists.length; i++) if (lists[i] != null) q.offer(i);
        ListNode yummy = new ListNode();
        ListNode node = yummy;
        while(!q.isEmpty()){
            int i = q.poll();
            ListNode list = lists[i];
            node.next = list;
            lists[i] = lists[i].next;
            list.next = null;
            node = node.next;
            if(lists[i] != null) q.offer(i);
        }
        return yummy.next;
    }
}