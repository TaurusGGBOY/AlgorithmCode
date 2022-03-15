import java.util.*;

class Solution {
    class Node {
        Node(int v) {
            val = v;
        }

        int val;
        Node left;
        Node right;
    }
    Map<Integer, Node> map;
    long max;
    int res;
    int[] p;

    public int countHighestScoreNodes(int[] parents) {
        map = new HashMap<>();
        max = 0;
        res = 0;
        p = parents;
        dfs(buildTree());
        return res;
    }

    private long dfs(Node root) {
        if (root == null) return 0;
        long sum = 1, l = dfs(root.left), r = dfs(root.right);
        sum *= (l == 0 ? 1 : l) * (r == 0 ? 1 : r) * (p[root.val] != -1 ? 1 : p.length - l - r - 1);
        if (sum > max) {
            max = sum;
            res = 1;
        } else if (sum == max) res++;
        return l + r + 1;
    }

    private Node buildTree() {
        Node root = null;
        for (int i = 0; i < p.length; i++) {
            Node temp = map.getOrDefault(i, new Node(i));
            Node parent = map.getOrDefault(p[i], new Node(p[i]));
            if (parent.left == null) parent.left = temp;
            else parent.right = temp;
            map.put(p[i], parent);
            map.put(i, temp);
            if (p[i] == -1) root = temp;
        }
        return root;
    }
}