import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
                nums[i] = 1;
            }
        }
        if (k < 0) return 0;
        for (int i = 0; i < nums.length; i++) queue.offer(nums[i]);
        while (k > 0) {
            queue.offer(queue.poll() + 1);
            k--;
        }
        long res = 1;
        while (!queue.isEmpty()) res = (res * queue.poll()) % 1000000007;
        return (int) res;
    }
}