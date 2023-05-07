import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node poll = q.poll();
                for (Node node : poll.children) q.offer(node);
                list.add(poll.val);
            }
            res.add(list);
        }
        return res;
    }
}