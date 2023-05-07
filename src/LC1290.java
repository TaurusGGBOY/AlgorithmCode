/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(String.valueOf(head.val));
            head = head.next;
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}