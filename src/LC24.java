/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        dfs(dummy);
        return dummy.next;
    }

    private void dfs(ListNode dummy) {
        if(dummy.next == null || dummy.next.next == null ) return;
        ListNode node = dummy.next;
        deleteNext(dummy);
        insertNext(dummy.next, node);
        dfs(dummy.next.next);
    }


    void insertNext(ListNode prev, ListNode node) {
        node.next = prev.next;
        prev.next = node;
    }

    void deleteNext(ListNode prev) {
        prev.next = prev.next.next;
    }
}