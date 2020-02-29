
/**
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (!stack.isEmpty())
            arrayList.add(stack.pop());
        return arrayList;
    }
}