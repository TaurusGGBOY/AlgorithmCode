import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int fillCups(int[] amount) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : amount) {
            if (i > 0) q.offer(i);

        }
        int res = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) {
                int temp1 = q.poll() - 1;
                int temp2 = q.poll() - 1;
                if (temp1 > 0) q.offer(temp1);
                if (temp2 > 0) q.offer(temp2);
                res++;
            } else if (q.size() == 1) {
                res += q.poll();
                break;
            }
        }
        return res;
    }
}