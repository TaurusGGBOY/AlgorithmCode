import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class MinStack {

    Deque<Integer> backupStack;
    Deque<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        backupStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if(backupStack.isEmpty() || backupStack.peekLast() >= x) backupStack.offerLast(x);
    }

    public void pop() {
        if(Objects.equals(backupStack.peekLast(), stack.pollLast())) backupStack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return backupStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */