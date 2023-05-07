import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        loop:
        for (int a : asteroids) {
            if (a > 0) {
                deque.offerLast(a);
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() <= -a) {
                int poll = deque.pollLast();
                if (poll == -a) continue loop;
            }
            if (deque.isEmpty()) list.add(a);
        }
        list.addAll(deque);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}