import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {

    int[] queue;
    int head;
    int tail;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new int[10001];
        head = 0;
        tail = 0;
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        if(head == tail) return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue[tail++] = value;
        while(!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if(head == tail) return -1;
        if(deque.peekFirst() == queue[head]) deque.pollFirst();
        head++;
        return queue[head - 1];
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */