import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        LinkedList<Integer> queue = new LinkedList<>();
        // 最左边的是最大的
        for (int i = 0; i < nums.length - 1; i++) {
            while (!queue.isEmpty() && queue.getFirst() < i - k + 1) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && dp[queue.getLast()] <= dp[i]) {
                queue.pollLast();
            }
            int temp = 0;
            try {
                temp = queue.getFirst();
            } catch (Exception e) {
                temp = i;
            }
            queue.offer(i);
            temp = Math.max(dp[i], dp[temp]);

            dp[i + 1] = temp + nums[i + 1];
            System.out.println(queue.toString());
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }
}

//[100,-1,-100,-1,100]
//2
//[100,-100,-300,-300,-300,-100,100]
//4