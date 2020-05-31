import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int num:nums)
            queue.add(num);
        int a = queue.poll();
        int b = queue.poll();
        return (a - 1) * (b - 1);
    }
}