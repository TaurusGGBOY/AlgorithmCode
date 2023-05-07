import java.util.Iterator;
import java.util.Vector;

class MyHashSet {
    Vector<Vector<Integer>> vectors;
    int size = 8;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        vectors = new Vector<>();
        for (int i = 0; i < size; i++) {
            Vector<Integer> vector = new Vector<>();
            vectors.add(vector);
        }
    }

    public void add(int key) {
        int pos = key % size;
        if (!contains(key)) {
            vectors.get(pos).add(key);
        }
    }

    public void remove(int key) {
        int pos = key % size;
        if (contains(key)) {
            Vector<Integer> vector = vectors.get(pos);
            Iterator<Integer> iterator = vector.iterator();
            while (iterator.hasNext()) {
                int num = iterator.next();
                if (num == key) {
                    iterator.remove();
                    return;
                }
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int pos = key % size;
        Vector<Integer> vector = vectors.get(pos);
        for (int num : vector) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */