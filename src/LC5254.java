import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] > o1[1]) swap(o1);
            if (o2[0] > o2[1]) swap(o2);
            return ((o1[2] * 1.0f / (o1[0] * o2[0])) - (o2[2] * 1.0f / (o2[0] * o2[0]))) > 0;
        });
        long res = 0;

    }
    .
    void swap(int[] o) {
        int temp = o[0];
        o[0] = o[1];
        o[1] = temp;
    }
}