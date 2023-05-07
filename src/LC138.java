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

import java.util.HashMap;

class Solution {
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map == null) map = new HashMap<>();
        if (map.containsKey(head)) return map.get(head);
        Node head1 = new Node(head.val);
        map.put(head, head1);
        head1.next = copyRandomList(head.next);
        head1.random = copyRandomList(head.random);
        return head1;
    }
}