import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int res = 0;
        for (int pile : piles) {
            queue.add(pile);
            res += pile;
        }

        for (int i = 0; i < k; i++) {
            int poll = queue.poll();
            res -= poll/2;
            poll = poll-poll/2;
            queue.offer(poll);
        }
        return res;
    }
}