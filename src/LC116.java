/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        if (root == null)
            return root;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            Node temp = nodes.poll();
            if (temp.left != null)
                nodes.offer(temp.left);
            if (temp.right != null)
                nodes.offer(temp.right);
            for (int i = 1; i < len; i++) {
                Node temp2 = nodes.poll();
                temp.next = temp2;
                if (temp2.left != null)
                    nodes.offer(temp2.left);
                if (temp2.right != null)
                    nodes.offer(temp2.right);
                temp = temp2;
            }
        }
        return root;
    }
}