import java.util.Deque;
import java.util.LinkedList;

class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;


    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.offer(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            stack2.addAll(stack1);
            stack1.clear();
        }
        return stack2.poll();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            stack2.addAll(stack1);
            stack1.clear();

        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack2.isEmpty()){
            stack2.addAll(stack1);
            stack1.clear();

        }
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */