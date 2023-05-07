import java.util.*;

class RandomizedSet {

    List<Integer> list;
   Map<Integer,Integer> map;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index1 = map.get(val);
        int val2 = list.get(list.size() - 1);
        list.set(index1, val2);
        list.remove(list.size() - 1);
        map.put(val2, index1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = new Random().nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */