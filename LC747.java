import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() <= 1) {
                minHeap.offer(i);
                continue;
            }
            if (nums[minHeap.peek()] < nums[i]) {
                minHeap.poll();
                minHeap.offer(i);
            }
        }
//        System.out.println(minHeap.toString());
        int min = minHeap.poll();
        int max = minHeap.poll();
        return nums[max] >= nums[min] * 2 ? max : -1;
    }
}