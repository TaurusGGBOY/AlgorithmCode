import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<String> deque = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '(') {
                deque.offerLast("(");
                continue;
            }
            int sum = 0;
            while (!deque.isEmpty() && !deque.peekLast().equals("(")) sum += Integer.valueOf(deque.pollLast());
            if (sum == 0) sum = 1;
            else sum <<= 1;
            if (!deque.isEmpty() && deque.peekLast().equals("(")) {
                deque.pollLast();
                deque.offerLast(String.valueOf(sum));
            }
        }
        int res = 0;
        while (!deque.isEmpty()) res += Integer.parseInt(deque.pollLast());
        return res;
    }
}