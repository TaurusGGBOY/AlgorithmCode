import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int poll = deque.pollLast();
                    int temp = deque.peekLast() + poll;
                    deque.offerLast(poll);
                    deque.offerLast(temp);
                    sum += temp;
                    break;
                case "D":
                    deque.offerLast(deque.peekLast() * 2);
                    sum += deque.peekLast();
                    break;
                case "C":
                    sum -= deque.pollLast();
                    break;
                default:
                    deque.offerLast(Integer.parseInt(op));
                    sum += deque.peekLast();
                    break;
            }
        }
        return sum;
    }
}