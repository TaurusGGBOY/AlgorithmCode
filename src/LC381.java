import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedCollection {

    List<Integer> list;
    HashMap<Integer, List<Integer>> indexMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        List<Integer> indexes;
        if (indexMap.containsKey(val)) {
            indexes = indexMap.get(val);
        } else {
            indexes = new ArrayList<>();
        }
        indexes.add(list.size()-1);
        indexMap.put(val, indexes);
        return indexes.size() < 2;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!list.contains(val))
            return false;
        if(list.size()==1)
        {
            list.clear();
            indexMap.clear();
            return true;
        }
        List<Integer> valList = indexMap.get(val);
        int index = valList.get(0);
        int lastTemp = list.get(list.size() - 1);
        int lastIndex = list.size()-1;
        list.set(index, lastTemp);
        list.remove(list.size() - 1);

        valList.remove(0);
        indexMap.put(val, valList);

        List<Integer> lastList = indexMap.get(lastTemp);
        int getLastList = lastList.indexOf(lastIndex);
        if(getLastList==-1)
            return true;
        lastList.set(lastList.indexOf(lastIndex),index);
        indexMap.put(lastTemp, lastList);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        Random random = new Random();
        int temp = random.nextInt(list.size());
        return list.get(temp);
    }
}
//
/////**
//// * Your RandomizedCollection object will be instantiated and called as such:
//// * RandomizedCollection obj = new RandomizedCollection();
//// * boolean param_1 = obj.insert(val);
//// * boolean param_2 = obj.remove(val);
//// * int param_3 = obj.getRandom();
//// */
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//class RandomizedCollection {
//    List<Integer> list;
//    /** Initialize your data structure here. */
//    public RandomizedCollection() {
//        list = new ArrayList<>();
//    }
//
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//        if(list.contains(val)){
//            list.add(val);
//            return false;
//        }
//        list.add(val);
//        return true;
//
//    }
//
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        try {
//            list.remove(list.indexOf(val));
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        Random random = new Random();
//        return list.get(random.nextInt(list.size()));
//    }
//}
//
///**
// * Your RandomizedCollection object will be instantiated and called as such:
// * RandomizedCollection obj = new RandomizedCollection();
// * boolean param_1 = obj.insert(val);
// * boolean param_2 = obj.remove(val);
// * int param_3 = obj.getRandom();
// */