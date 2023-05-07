import java.util.Vector;

class MyHashMap {
  Vector<Vector<Entry>> vectors;
  int cap = 8;
  /** Initialize your data structure here. */
  public MyHashMap() {
    vectors = new Vector<>();
    for (int i = 0; i < cap; i++) {
      vectors.add(new Vector<>());
    }
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int num = key % cap;
    Vector<Entry> vector = vectors.get(num);
    for (int i = 0; i < vector.size(); i++) {
      if (vector.get(i).key == key) {
        vector.get(i).val = value;
        return;
      }
    }
    vector.add(new Entry(key, value));
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    int num = key % cap;
    Vector<Entry> vector = vectors.get(num);
    for (int i = 0; i < vector.size(); i++) {
      Entry entry = vector.get(i);
      if (entry.key == key) return entry.val;
    }
    return -1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int num = key % cap;
    Vector<Entry> vector = vectors.get(num);

    for (int i = 0; i < vector.size(); i++) {
      Entry entry = vector.get(i);
      if (entry.key == key) {
        vector.remove(i);
        return;
      }
    }
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
class Entry {
  int key;
  int val;

  public Entry() {}

  public Entry(int key, int val) {
    this.key = key;
    this.val = val;
  }
}
