import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer, List<AbstractMap.SimpleEntry<Integer, BigInteger>>> map = new HashMap<>();
        for (int j = 0; j <= 101; j++) {
            List<AbstractMap.SimpleEntry<Integer, BigInteger>> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                String s = nums[i].substring(Math.max(0, nums[i].length() - j));
                if (s.isEmpty()) s = "0";
                list.add(new AbstractMap.SimpleEntry<>(i, new BigInteger(s)));
            }
            ConcurrentHashMap map = new ConcurrentHashMap();
            map.size()
            Collections.sort(list, (o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) return o1.getKey() - o2.getKey();
                return o1.getValue().compareTo(o2.getValue());
            });
            map.put(j, list);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.get(queries[i][1]).get(queries[i][0]-1).getKey();
        }
        return res;
    }
}