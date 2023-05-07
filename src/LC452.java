import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] <= o1[1] ? -1 : 1;
                }
                return o1[0] <= o2[0] ? -1 : 1;
            }
        });
        int startPos = 0;
        int count = 0;
        int minR = points[0][1];
        count++;
        startPos++;
        while (startPos < points.length) {
            if (points[startPos][0] > minR) {
                count++;
                minR = points[startPos][1];
            } else {
                minR = Math.min(minR, points[startPos][1]);
            }
            startPos++;
        }
        return count;
    }
}