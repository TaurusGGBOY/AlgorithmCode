import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap = new PriorityQueue<Integer>(k);
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > heap.peek()) {
				heap.poll();

				heap.add(nums[i]);
			}
		}
		return heap.peek();
	}
}