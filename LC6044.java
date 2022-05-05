import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer, Integer> birthCount = new TreeMap();
        TreeMap<Integer, Integer> deadCount = new TreeMap();
        TreeMap<Integer, Integer> birthPrefix = new TreeMap<>();
        TreeMap<Integer, Integer> deadPrefix = new TreeMap<>();
        for (int[] flower : flowers) {
            birthCount.merge(flower[0], 1, Integer::sum);
            deadCount.merge(flower[1], 1, Integer::sum);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = birthCount.entrySet().iterator();
        int last = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            last += entry.getValue();
            birthPrefix.put(entry.getKey(), last);
        }

        iterator = deadCount.entrySet().iterator();
        last = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            last += entry.getValue();
            deadPrefix.put(entry.getKey(), last);
        }

        int[] res = new int[persons.length];
        for (int i = 0; i < res.length; i++) {
            Map.Entry<Integer, Integer> birthEntry = birthPrefix.floorEntry(persons[i]);
            if(birthEntry == null){
                res[i] = 0;
                continue;
            }
            Map.Entry<Integer, Integer> deadEntry = deadPrefix.lowerEntry(persons[i]);
            if (deadEntry ==  null) {
                res[i] = birthEntry.getValue();
                continue;
            }
            res[i] = birthEntry.getValue() - deadEntry.getValue();
        }
        return res;

    }
}