import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            deque.offerLast(pushed[i]);
            while (!deque.isEmpty() && j < popped.length && popped[j] == deque.peekLast()) {
                deque.pollLast();
                j++;
            }
        }
        return deque.isEmpty();
    }
}