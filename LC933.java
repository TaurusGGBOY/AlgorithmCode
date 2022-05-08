import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offer(t);
        while (deque.peek() < t - 3000) deque.poll();
        return deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */