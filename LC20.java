import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if(stack.isEmpty()) stack.offerLast(c);
            else if(c == ')' && stack.peekLast()=='(') stack.pollLast();
            else if(c == '}' && stack.peekLast()=='{') stack.pollLast();
            else if(c == ']' && stack.peekLast()=='[') stack.pollLast();
            else stack.offerLast(c);
        }
        return stack.isEmpty();
    }
}