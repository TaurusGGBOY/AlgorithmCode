import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int fillCups(int[] amount) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : amount) {
            if (i > 0) q.offer(i);
        }

        int res = 0;
        while (!q.isEmpty()) {
            int temp1 = q.poll();
            if (q.isEmpty()) {
                res += temp1;
                break;
            }

            int temp2 = q.poll();
            if (temp1 > 1) q.offer(temp1 - 1);
            if (temp2 > 1) q.offer(temp2 - 1);
            res++;
        }
        return res;
    }
}