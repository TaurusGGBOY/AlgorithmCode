import java.util.PriorityQueue;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] res = new int[barcodes.length];

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return -o1[1] + o2[1];
        });

        int[] counter = new int[100001];
        for (int b : barcodes) {
            counter[b]++;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) continue;
            queue.offer(new int[]{i, counter[i]});
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int[] poll1 = queue.poll();
            res[index++] = poll1[0];
            if (poll1[1] != 1) {
                poll1[1]--;
                queue.offer(poll1);
            }
        }

        return res;
    }
}