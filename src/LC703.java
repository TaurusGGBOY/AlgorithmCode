import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

    Queue<Integer> queue;
    int knum;

    public KthLargest(int k, int[] nums) {
        knum = k;
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (queue.size() < knum) {
            queue.add(val);
            return queue.peek();

        }
        if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */