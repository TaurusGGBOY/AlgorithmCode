import java.util.*;

class Solution {
    Map<Node, Node> vis = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(vis.containsKey(node)) return vis.get(node);
        Node temp = new Node(node.val, new ArrayList<>());
        vis.put(node, temp);
        for (Node n : node.neighbors) temp.neighbors.add(cloneGraph(n));
        return temp;
    }


}