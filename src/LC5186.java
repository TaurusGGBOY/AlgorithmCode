import java.util.*;

class RangeFreqQuery {
    Map<Integer, TreeMap<Integer, Integer>> valueTime;
    public RangeFreqQuery(int[] arr) {
        valueTime = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            TreeMap<Integer, Integer> map = valueTime.getOrDefault(arr[i], new TreeMap<>());
            map.put(i, map.size()+1);
            valueTime.put(arr[i], map);
        }
    }

    public int query(int left, int right, int value) {
        TreeMap<Integer, Integer> map = valueTime.getOrDefault(value, new TreeMap<>());
        Integer r = map.floorKey(right);
        Integer l = map.lowerKey(left);
        if(r==null) return 0;
        if(l==null) return map.get(r);
        return map.get(r)-map.get(l);
    }
}