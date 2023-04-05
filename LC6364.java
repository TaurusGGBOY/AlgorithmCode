import java.util.*;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        Queue<int[]> q = new PriorityQueue<>((o1, o2) ->  (o2[0]-o2[1])-(o1[0]-o1[1]));
        for (int i = 0; i < reward1.length; i++) {
            q.offer(new int[]{reward1[i], reward2[i]});
        }
        int score = 0;
        for (int i = 0; i < k; i++) {
            score += q.poll()[0];
        }
        for (int i = k; i < reward1.length; i++) {
            score += q.poll()[1];
        }
        return score;
    }
}