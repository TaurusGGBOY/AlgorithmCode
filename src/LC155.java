import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

//import java.util.PriorityQueue;
//import java.util.Stack;
//
//class MinStack {
//    PriorityQueue<Integer> queue;
//    Stack<Integer> stack;
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//        stack = new Stack<>();
//        queue = new PriorityQueue<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        queue.add(x);
//    }
//
//    public void pop() {
//        stack.pop();
//        queue.clear();
//        queue.addAll(stack);
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return queue.peek();
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(x);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */
//class MinStack {
//
//    Stack<Integer> stack;
//    Stack<Integer> min_stack;
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//        min_stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if(min_stack.isEmpty()||x<=min_stack.peek())
//            min_stack.push(x);
//    }
//
//    public void pop() {
//        if(stack.pop().equals(min_stack.peek()))
//            min_stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min_stack.peek();
//    }
//}
public class MinStack {
    long min;
    Stack<Long> stack;
ArrayBlockingQueue
    public MinStack(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x - min);
        } else {
            stack.push(x - min);
            if (x < min){
                min = x; // 更新最小值
            }

        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        long pop = stack.pop();

        //弹出的是负值，要更新 min
        if (pop < 0) {
            min = min - pop;
        }

    }

    public int top() {
        long top = stack.peek();
        //负数的话，出栈的值保存在 min 中
        if (top < 0) {
            return (int) (min);
            //出栈元素加上最小值即可
        } else {
            return (int) (top + min);
        }
    }

    public int getMin() {
        return (int) min;
    }
}
