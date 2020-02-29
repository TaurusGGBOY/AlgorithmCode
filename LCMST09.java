import java.util.Stack;

class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack2.add(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty())
                stack1.add(stack2.pop());
        }
        if (stack1.isEmpty())
            return -1;
        return stack1.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */