import java.util.PriorityQueue;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            int dis = dist[i];
            int t = (int)Math.ceil(dis*1.0f/speed[i]);
            queue.offer(t);
        }
        do {
            int poll = queue.poll();
            time++;
        } while (!queue.isEmpty() && queue.peek() - time > 0);
        return time;
    }
}