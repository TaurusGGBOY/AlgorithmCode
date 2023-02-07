import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class StockSpanner {

    Deque<int[]> deque;
    int i;

    public StockSpanner() {
        deque = new ArrayDeque<>();
        i = -1;
        deque.offerLast(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        i++;
        while (!deque.isEmpty() && deque.peekLast()[1] <= price) deque.pollLast();
        int res = i - deque.peekLast()[0];
        deque.offerLast(new int[]{i, price});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */