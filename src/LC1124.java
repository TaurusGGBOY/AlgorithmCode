import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestWPI(int[] hours) {
        Deque<Integer> deque = new ArrayDeque<>();
        int tired = 0, notTired = 0;
        int res = 0;
        for (int hour : hours) {
            if(hour > 8) {
                deque.offerLast(hour);
                res =
            }

        }

    }
}