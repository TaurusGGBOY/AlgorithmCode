import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int r = 1;
        Arrays.sort(nums);
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        while (r < nums.length) {
            int l = 0;
            while (l < r) {
                if (queue.size() < k) queue.offer(nums[r] - nums[l]);
                else {
                    queue.offer(nums[r] - nums[l]);
                    queue.poll();
                }
                l++;
            }
            r++;
        }
        // 4 62 100
        // 58  96 38
        return queue.peek();
    }
}