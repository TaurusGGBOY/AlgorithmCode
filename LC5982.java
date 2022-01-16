import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long mostPoints(int[][] qs) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        long[] dp = new long[qs.length];
        long canUseMax =0;
        long res = 0;
        for (int i = 0; i < qs.length; i++) {
            int[] q = qs[i];
            while(!queue.isEmpty()&&queue.peek()[0]<i) canUseMax = Math.max(dp[queue.poll()[1]], canUseMax);
            dp[i] = q[0] + canUseMax;
            res = Math.max(dp[i], res);
            queue.offer(new int[]{i + q[1], i});
        }
        return res;
    }
}