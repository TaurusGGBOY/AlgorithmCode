import java.util.PriorityQueue;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int cost : costs) {
            queue.add(cost);
        }
        int count = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll > coins) {
                return count;
            }
            coins -= poll;
            count++;
        }
        return count;
    }
}