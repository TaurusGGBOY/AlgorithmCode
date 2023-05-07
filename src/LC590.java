/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;

class Solution {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    void dfs(Node root) {
        if(root == null) return;
        for (Node node : root.children) {
            dfs(node);
        }
        res.add(root.val);
    }
}