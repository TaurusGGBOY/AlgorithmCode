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
        if(root==null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
//            System.out.println(size);
            Node temp = queue.poll();
            temp.next=null;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            for (int i = 1; i < size; i++) {
                Node node = queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                temp.next=node;
                temp=node;
                temp.next=null;

            }
        }
        return root;
    }
}