import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int res = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            res = queue.poll();
        }
        return res;
    }
}