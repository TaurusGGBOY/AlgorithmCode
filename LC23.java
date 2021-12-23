import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> lists[o1].val - lists[o2].val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        int poll = queue.poll();
        ListNode tail = new ListNode(lists[poll].val, null);
        lists[poll] = lists[poll].next;
        if (lists[poll] != null) {
            queue.offer(poll);
        }
        ListNode prev = new ListNode(-1, tail);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            ListNode node = lists[temp];
            ListNode next = node.next;
            add(tail, node);
            tail = tail.next;
            lists[temp] = next;
            if (next != null) {
                queue.offer(temp);
            }
        }
        return prev.next;
    }

    void add(ListNode prev, ListNode node) {
        node.next = prev.next;
        prev.next = node;
    }
}