import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for (int[] interval : intervals) {
            Queue<Integer> queue = map.getOrDefault(interval[0], new PriorityQueue<>());
            queue.offer(interval[1]);
            map.put(interval[0], queue);
        }

        int res = 0;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Queue<Integer>> entry = map.firstEntry();
            int start = entry.getKey();
            int end = entry.getValue().poll();
            if(entry.getValue().isEmpty()) map.remove(start);
            while (true) {
                Map.Entry<Integer, Queue<Integer>> entry2 = map.higherEntry(end);
                if(entry2 ==null) break;
                start = entry2.getKey();
                end = entry2.getValue().poll();
                if(entry2.getValue().isEmpty()) map.remove(start);
            }
            res++;
        }
        return res;
    }
}