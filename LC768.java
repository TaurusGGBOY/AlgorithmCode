import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peekLast() <= arr[i]) {
                stack.offerLast(arr[i]);
                continue;
            }
            int max = stack.pop();
            while(!stack.isEmpty() && stack.peekLast() > arr[i]) stack.pollLast();
            stack.offerLast(max);
        }
        return stack.size();
    }

}