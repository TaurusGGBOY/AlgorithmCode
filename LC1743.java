import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            List<Integer> list = map.getOrDefault(adjacentPairs[i][0], new ArrayList<>());
            list.add(adjacentPairs[i][1]);
            map.put(adjacentPairs[i][0], list);
            List<Integer> list2 = map.getOrDefault(adjacentPairs[i][1], new ArrayList<>());
            list2.add(adjacentPairs[i][0]);
            map.put(adjacentPairs[i][1], list2);
        }
        AtomicInteger start = new AtomicInteger();
        map.entrySet().stream().filter(entry -> entry.getValue().size() == 1).limit(1).forEach(entry -> start.set(entry.getKey()));

        int s = start.intValue();
        int[] res = new int[adjacentPairs.length + 1];
        res[0] = s;
        res[1] = map.get(s).get(0);
        s = res[1];
        for (int i = 2; i < res.length; i++) {
            List<Integer> list = map.get(s);
//            System.out.println(Arrays.toString(res));
//            System.out.println(s+" "+list.toString());
            int zero = list.get(0);
            int one = list.get(1);
            if (res[i - 2] == zero) {
                res[i] = one;
                s=one;
            }else{
                res[i] = zero;
                s = zero;
            }
        }
        return res;
    }
}