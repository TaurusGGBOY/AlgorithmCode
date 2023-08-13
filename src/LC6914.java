import java.math.BigInteger;

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
    public ListNode doubleIt(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }

        BigInteger bigInteger = new BigInteger(stringBuilder.toString());
        bigInteger = bigInteger.multiply(BigInteger.TWO);

        String s = bigInteger.toString();

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        for (int i = 0; i < s.length(); i++) {
            temp.next = new ListNode(s.charAt(i) - '0');
            temp = temp.next;
        }

        return dummy.next;
    }
}