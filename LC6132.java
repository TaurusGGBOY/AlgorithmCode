import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minimumOperations(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer(num);
        }
        int res = 0;
        int max = 0;
        while (!q.isEmpty()) {
            if (max >= q.peek()) q.poll();
            else {
                max = q.poll();
                res++;
            }
        }
        return res;
    }
}