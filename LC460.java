import java.util.*;

class LFUCache {

    TreeMap<Integer, Node> map;

    public LFUCache(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }

    class Node {
        LinkedList<AbstractMap.SimpleEntry<Integer,Integer>> list;
        Map<Integer, Integer> map;

        boolean containsKey(int key) {
            return map.containsKey(key);
        }

        int remove(int key){

        }

        boolean insert(int key){

        }

        boolean get(int key) {
        }

        boolean set(int key, int value) {

        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */