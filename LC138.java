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
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node res = new Node(0);
        Node first = new Node(0);
        first.next = head;
        Node temp = res;
        while(head!=null){
            temp.next = new Node(head.val);
            map.put(head,temp.next);
            temp = temp.next;
            head = head.next;
        }
        head = first.next;
        temp = res.next;
        while(head!=null){
            if(head.random==null){
                temp.random = null;
            }else{
                temp.random = map.get(head.random);
            }
            head = head.next;
            temp = temp.next;
        }
        return res.next;
    }
}