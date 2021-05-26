// TODO 失败
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseParentheses(String s) {
        Deque<Deque<Character>> dequeDeque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                dequeDeque.offerLast(new ArrayDeque<>());
            } else if (c == ')') {
                Deque<Character> poll = dequeDeque.pollLast();
                System.out.println(poll.toString());
                while (!poll.isEmpty()) {
                    stringBuilder.append(poll.poll());
                }
            } else {
                if (dequeDeque.isEmpty()) {
                    stringBuilder.append(c);
                }else{
                    Deque<Character> peek = dequeDeque.peekLast();
                    peek.offerLast(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}