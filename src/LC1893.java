import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] <= left) {
                left = Math.max(ranges[i][1] + 1, left);
            }
        }
        return left > right;
    }
}