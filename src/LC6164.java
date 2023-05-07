import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = getSum(num);
            Queue<Integer> queue = map.getOrDefault(sum, new PriorityQueue<>());
            queue.offer(num);
            if (queue.size() > 2) queue.poll();
            map.put(sum, queue);
        }
        int res = -1;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() < 2) continue;
            res = Math.max(entry.getValue().poll() + entry.getValue().poll(), res);
        }
        return res;
    }

    int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}