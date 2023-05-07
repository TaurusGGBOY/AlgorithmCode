import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                if (size() > capacity)
                    return true;
                return false;
            }
        };
    }

    public int get(int key) {
        try {
            return linkedHashMap.get(key);
        } catch (Exception e) {
            return -1;
        }

    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }
}