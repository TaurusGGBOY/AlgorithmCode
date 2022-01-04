import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    Map<Integer, Node> map;
    Node yummy;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        yummy = new Node();
        tail = new Node();
        yummy.next = tail;
        tail.prev = yummy;
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.val = value;
            insert(node);
            return;
        }
        if (cap <= map.entrySet().size()) {
            Node head = yummy.next;
            remove(head);
            map.remove(head.key);
        }
        Node node = new Node();
        node.key = key;
        node.val = value;
        map.put(key, node);
        insert(node);
    }

    public void remove(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

}
