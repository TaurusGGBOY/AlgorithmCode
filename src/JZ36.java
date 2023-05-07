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

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        head = pre = root;
        while (head.left != null) head = head.left;
        while (pre.right != null) pre = pre.right;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        pre.right = cur;
        cur.left = pre;
        pre = cur;
        if (cur.right != head) dfs(cur.right);
    }
}