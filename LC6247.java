import javax.swing.tree.TreeNode;
import java.util.TreeMap;

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
    public ListNode removeNodes(ListNode head) {
        TreeMap<ListNode, ListNode> map = new TreeMap<>((o1, o2) -> o1.val - o2.val);

        ListNode yummy = new ListNode(-1, head);
        ListNode curr = yummy;

        while (curr.next != null) {
            ListNode node = curr.next;
            map.put(node, node);
            curr = curr.next;
        }

        curr = yummy;

        while (curr.next != null) {
            ListNode node = curr.next;
            ListNode maxNode = map.lastKey();
//            System.out.println(node.val + " " + maxNode.val);
            if (node.val < maxNode.val) {
                curr.next = node.next;
            }else{
                curr = curr.next;
            }
            map.remove(node, node);
        }
        return yummy.next;
    }
}