import java.util.AbstractMap;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // o1.getkey / o1.getvalue - o2.getkey / o2.getvalue = k
        // o1.getkey * o2.getvalue - o2.getkey * o1.getvalue = k * o1.getvalue * o2.getvalue;
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> q = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                return o1.getKey() * o2.getValue() - o2.getKey() * o1.getValue();
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                AbstractMap.SimpleEntry<Integer, Integer> e = new AbstractMap.SimpleEntry(arr[i], arr[j]);
                q.offer(e);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }
        AbstractMap.SimpleEntry<Integer, Integer> poll = q.poll();
        return new int[]{poll.getKey(), poll.getValue()};
    }
}