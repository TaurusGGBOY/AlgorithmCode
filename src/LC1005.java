import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int minPos = Integer.MAX_VALUE;
        int sum = 0;
        Queue<Integer> neg = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) {
                neg.offer(num);
                sum += num;
            } else {
                minPos = Math.min(num, minPos);
                sum += num;
            }
        }
        int r = k;
        for (; r > 0 && !neg.isEmpty(); r--) {
            int poll = neg.poll();
            minPos = Math.min(-poll, minPos);
            sum += -poll;
            sum -= poll;
        }
        if (r % 2 == 1) {
            sum += -minPos * 2;
        }
//        System.out.println(pos.toString());
//        System.out.println(neg.toString());
//        System.out.println();
        return sum;
    }
}