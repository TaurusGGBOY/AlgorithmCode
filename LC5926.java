import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<AbstractMap.SimpleEntry<Integer,Integer>> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new AbstractMap.SimpleEntry<>(i, tickets[i]));
        }
        int time=0;
        while (!queue.isEmpty()) {
            time++;
            AbstractMap.SimpleEntry<Integer, Integer> poll = queue.poll();
            int val = poll.getValue() - 1;
            if (val <= 0) {
                if (poll.getKey() == k) {
                    break;
                }
            }else{
                queue.offer(new AbstractMap.SimpleEntry<>(poll.getKey(), val));
            }
        }
        return time;
    }
}