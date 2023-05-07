import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reformatNumber(String number) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '-' || c == ' ') continue;
            deque.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            if(deque.size() == 4)sb.append(("-")).append(deque.pollFirst()).append(deque.pollFirst());
            else if(deque.size() == 2) sb.append(("-")).append(deque.pollFirst()).append(deque.pollFirst());
            else sb.append(("-")).append(deque.pollFirst()).append(deque.pollFirst()).append(deque.pollFirst());
        }
        if(sb.charAt(0) == '-') return sb.substring(1).toString();
        return sb.toString();
    }
}