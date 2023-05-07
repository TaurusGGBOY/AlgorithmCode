
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            try {
                int temp = Integer.parseInt(token);
                stack.push(temp);
            } catch (Exception e) {
                int temp = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(temp + stack.pop());
                        break;
                    case "-":
                        stack.push(stack.pop()-temp);
                        break;
                    case "*":
                        stack.push(temp * stack.pop());
                        break;
                    case "/":
                        stack.push(stack.pop()/temp);
                        break;
                    default:
                        break;
                }
//                System.out.println(stack.peek());
            }
        }
        return stack.peek();
    }
}
//3
//9
//0
//4
//12
//-132
//-22
//-220
//-203
//-198