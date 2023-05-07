//执行用时：
//        12 ms
//        , 在所有 Java 提交中击败了
//        5.04%
//        的用户
//        内存消耗：
//        40.9 MB
//        , 在所有 Java 提交中击败了
//        73.22%
//        的用户
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Map<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int[] interval : intervals) {
            map.put(interval[0], interval[1]);
            min = Math.min(interval[0], min);
            max = Math.max(interval[1], max);
        }
        if (newInterval[1] < min || newInterval[0] > max) {
            map.put(newInterval[0], newInterval[1]);
            int[][] res = new int[map.size()][2];
            mapToMatrix(res, map);
            return res;
        }
        List<Integer> deleteList = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int insertStart = newInterval[0];
        int insertEnd = newInterval[1];

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();

            if ((insertStart >= next.getKey() && insertStart <= next.getValue()) || (insertEnd >= next.getKey() && insertEnd <= next.getValue())||(insertStart <= next.getKey() && insertEnd >= next.getValue())) {
                insertStart = Math.min(insertStart, next.getKey());
                insertEnd = Math.max(insertEnd, next.getValue());
                deleteList.add(next.getKey());
                break;
            }
        }

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (insertEnd >= next.getKey()) {
                deleteList.add(next.getKey());
                insertEnd = Math.max(insertEnd, next.getValue());
            } else {
                break;
            }
        }
        // 删除标记结点
        for (Integer integer : deleteList) {
            map.remove(integer);
        }

        // 添加新增结点
        map.put(insertStart, insertEnd);

        int[][] res = new int[map.size()][2];
        mapToMatrix(res, map);
        return res;
    }

    void mapToMatrix(int[][] res, Map<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        for (int i = 0; i < map.entrySet().size(); i++) {
            Map.Entry<Integer, Integer> next = iterator.next();
            res[i][0] = next.getKey();
            res[i][1] = next.getValue();
        }
    }
}