import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int a : arr) {
            if (queue.size() < k) {
                queue.offer(a);
            }else{
                int peek = queue.peek();
                if (peek > a) {
                    queue.poll();
                    queue.offer(a);
                }
            }
        }
        return queue.stream().mapToInt(Integer::valueOf).toArray();
    }

}