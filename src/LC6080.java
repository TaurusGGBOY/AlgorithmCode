import java.util.ArrayDeque;

class Solution {

    public int totalSteps(int[] nums) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int round = 1;
            while (!deque.isEmpty() && nums[deque.peekLast()[0]] <= nums[i]) round = Math.max(round, deque.pollLast()[1] + 1);
            if (!deque.isEmpty()) ans = Math.max(ans, round);
            deque.offerLast(new int[]{i, round});
        }
        return ans;
    }
}