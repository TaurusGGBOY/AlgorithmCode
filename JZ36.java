/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        Node res = dfs(root);
        return res;
    }

    Node dfs(Node root) {
        Node node1 = dfs(root.left);
        Node node2 = dfs(root.right);
        node1.right = root;
        node2.left = root;


    }
}