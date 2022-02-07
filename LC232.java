import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.offerLast(x);
    }

    public int pop() {
        if(stack2.isEmpty())while(!stack1.isEmpty()) stack2.offerLast(stack1.pollLast());
        return stack2.pollLast();
    }

    public int peek() {
        if(stack2.isEmpty())while(!stack1.isEmpty()) stack2.offerLast(stack1.pollLast());
        return stack2.peekLast();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
