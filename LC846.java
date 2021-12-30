import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            int count = map.getOrDefault(i, 0);
            count++;
            map.put(i, count);
        }
        for (int i = 0; i < hand.length / groupSize; i++) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> next = iterator.next();
            int lastKey = next.getKey();
            int lastVal = next.getValue();
            if (lastVal == 1) {
                iterator.remove();
            }else{
                map.put(lastKey, lastVal - 1);
            }
            int count = 1;
            while (iterator.hasNext() && count < groupSize) {
                next = iterator.next();
                int key = next.getKey();
                int val = next.getValue();
//                System.out.println(key+" "+val);
                if (key != lastKey + 1) {
                    return false;
                }
                lastKey = key;
                if (val == 1) {
                    iterator.remove();
                }else{
                    map.put(key, val - 1);
                }
                count++;
            }
            if (count < groupSize) {
                return false;
            }
        }
//        System.out.println();
        return true;
    }
}