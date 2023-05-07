import java.util.Stack;

class MinStack {
    int[] a;
    int point;
    int cap;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        cap = 100000;
        a = new int[cap];
        point = 0;
        stack.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if (point == a.length - 1) {
            int[] b = new int[a.length * 2];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
        if (x <= stack.peek()) {

            stack.add(x);
        }

        a[point++] = x;
    }

    public void pop() {
        if (a[point - 1] == stack.peek()) {
            stack.pop();
        }
        point--;

    }

    public int top() {
        return a[point - 1];
    }

    public int getMin() {
        return stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */