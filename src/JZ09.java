import java.util.ArrayDeque;
import java.util.Deque;

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    public void appendTail(int value) {
        stack1.offerLast(value);
    }
    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.offerLast(stack1.pollLast());
            }
        }
        if(stack2.isEmpty()) return -1;
        return stack2.pollLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */