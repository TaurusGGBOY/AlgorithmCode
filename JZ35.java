import java.util.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node head1 = head;
        Map<Node, Node> map = new HashMap<>();
        Node head2 = new Node(head.val);
        map.put(head, head2);
        while (head != null) {
            if (head.next != null) {
                Node next = map.getOrDefault(head.next, new Node(head.next.val));
                map.put(head.next, next);
                head2.next = next;
            }
            if (head.random != null) {
                Node random = map.getOrDefault(head.random, new Node(head.random.val));
                map.put(head.random, random);
                head2.random = random;
            }
            head2 = head2.next;
            head = head.next;
        }
        return map.get(head1);
    }
}