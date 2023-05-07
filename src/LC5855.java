import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Queue<BigInteger> queue = new PriorityQueue<>();
        for (String num : nums) {
            BigInteger integer = new BigInteger(num);
            if (queue.size() < k ) {
                queue.offer(integer);
            } else {
                if (queue.peek().compareTo(integer) < 0) {
                    queue.poll();
                    queue.offer(integer);
                }
            }
        }
//        System.out.println(queue.toString());
        return queue.peek().toString();
    }
}