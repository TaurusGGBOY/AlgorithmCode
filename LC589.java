import java.util.*;
import java.util.concurrent.Executors;

class Solution {
    List<Integer> res;

    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    void dfs(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) dfs(node);
    }
}