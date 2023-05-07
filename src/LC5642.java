import java.math.BigInteger;
import java.util.*;

class Solution {
    public int countPairs(int[] deliciousness) {
        final int MAX_SIZE = 1000000007;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 21; i++) {
            set.add((int) (Math.pow(2, i)));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            map.merge(deliciousness[i], 1, (oldval, newval) -> oldval + newval);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        System.out.println(map.toString());
        long count = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int val = entry.getValue();
            for (int num : set) {
                int temp = num - key;
//                System.out.println("temp,"+temp+" val,"+val);
                if (temp == key) {
                    count = (count+val*(val-1))%MAX_SIZE;
                } else if (map.containsKey(temp)) {
                    count = (count+val*map.get(temp))%MAX_SIZE;
                }
//                System.out.println("count,"+count);
            }
//            System.out.println(count);
        }
        return (int)(count/2);
    }

}