import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(interval[1]);
            if (entry == null) continue;
            if (entry.getKey() >= interval[1]) res[i] = entry.getValue();
        }
        return res;
    }
}