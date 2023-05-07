import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (k <= 1) return nums;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        int[] res = new int[nums.length - k + 1];
        for (int i = 1; i < k; i++) {
            if (nums[i] >= nums[deque.peekLast()]) deque.offerLast(i);
        }
        res[0] = nums[deque.peekLast()];
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            if (deque.isEmpty()) {
                deque.offerLast(i - k + 1);
                for (int j = i - k + 2; j < i; j++) {
                    if (nums[j] >= nums[deque.peekLast()]) deque.offerLast(j);
                }
            }
            if (nums[i] >= nums[deque.peekLast()]) deque.offerLast(i);
            res[i - k + 1] = nums[deque.peekLast()];
        }
        return res;
    }
}