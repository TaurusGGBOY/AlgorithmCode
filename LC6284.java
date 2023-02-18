import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            q.offer(num);
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            int poll = q.poll();
            res += poll;
            q.offer(ceil(poll));
        }
        return res;
    }

    int ceil(int num) {
        if (num % 3 == 0) return num / 3;
        return num / 3 + 1;
    }
}