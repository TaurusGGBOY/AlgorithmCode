import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.net.HttpURLConnection;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.net.Socket;
class LRUCache {

    LinkedHashMap<Integer,Integer> linkedHashMap;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */