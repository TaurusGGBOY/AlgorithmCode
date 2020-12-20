// TODO 失败
import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length ];
        dp[0] = nums[0];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            while (!queue.isEmpty() && queue.getFirst() < i - (k - 1)) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.getLast() < dp[i]) {
                queue.pollLast();
            }
            int temp =0;
            try {
                temp = queue.getLast();
            }
            catch (Exception e)
            {

            }
            queue.offer(i);
            temp = Math.max(dp[i],dp[temp]);

            dp[i + 1] = temp + nums[i + 1];
        }
        return dp[nums.length-1];
    }
}