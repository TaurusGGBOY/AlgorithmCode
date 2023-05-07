import java.util.*;

class Solution {
    Map<Node, Node> vis = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(redVis.containsKey(node)) return redVis.get(node);
        Node temp = new Node(node.val, new ArrayList<>());
        redVis.put(node, temp);
        for (Node n : node.neighbors) temp.neighbors.add(cloneGraph(n));
        return temp;
    }


}