import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(Long.parseLong("1"));
        int count = 0;
        long res = 1;
        Set<Long> set = new HashSet<>();
        set.add(Long.parseLong("1"));
        while (count < n) {
            res = queue.poll();
            count++;
            if (!set.contains(res * 2)) {
                queue.add(res * 2);
                set.add(res * 2);
            }
            if (!set.contains(res * 3)) {
                queue.add(res * 3);
                set.add(res * 3);
            }
            if (!set.contains(res * 5)) {
                queue.add(res * 5);
                set.add(res * 5);
            }
        }
        return (int)res;
    }
}