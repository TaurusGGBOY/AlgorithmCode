import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int[][] res = new int[matrix.length][matrix[0].length];
        res[0][0] = matrix[0][0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(res[0][0]);
        if (matrix[0].length > 1) {
            for (int i = 1; i < matrix[0].length; i++) {
                res[0][i] = res[0][i - 1] ^ matrix[0][i];
                queue.add(res[0][i]);
            }
        }
        if (matrix.length > 1) {
            for (int i = 1; i < matrix.length; i++) {
                res[i][0] = res[i - 1][0] ^ matrix[i][0];
                queue.add(res[i][0]);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                try {
                    res[i][j] = res[i - 1][j - 1] ^ res[i - 1][j] ^ res[i][j - 1] ^ matrix[i][j];
                    queue.add(res[i][j]);
                } catch (Exception e) {

                }

            }
        }
//        System.out.println(queue.toString());
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}