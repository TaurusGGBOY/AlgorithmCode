import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 1;
        int sum = 0;
        Deque<Integer> queue = new LinkedList<>();
        List<int[]> list = new LinkedList<>();
        int[] temp;
        int row = 0;
        for (int i = 1; i <= target / 2; i++) {
            while (r <= target / 2 + 1) {
                queue.add(r);
                sum += r;
                r++;
                while (sum > target) {
                    sum -= l;
                    l++;
                    queue.pollFirst();
                }
                if (sum == target) {
                    temp = new int[r - l];
                    for (int j = l; j <= r - 1; j++) {
                        temp[j - l] = j;
                    }
                    list.add(temp);
                    row++;
                }
            }
        }
        int[][] out = new int[list.size()][];

        return list.toArray(out);
    }
}