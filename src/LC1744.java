// TODO 失败
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        PriorityQueue<int[]> queryQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (int[] query : queries) {
            queryQueue.offer(query);
        }
        while()

    }
}