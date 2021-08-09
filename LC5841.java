import java.awt.print.Printable;
import java.util.*;

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] res = new int[obstacles.length];
        List<Integer> dp = new ArrayList<>();
        dp.add(obstacles[0]);
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            if (obstacles[i] >= dp.get(dp.size() - 1)) {
                dp.add(obstacles[i]);
                res[i] = dp.size() + 1;
            }
            int l = 0;
            int r = dp.size() - 1;
            int m = (l + r) / 2;
            while (l < r) {
                m = (l + r) / 2;
                if (dp.get(m) <= obstacles[i]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp.set(r, obstacles[i]);
            res[i] = r + 1;
        }
//        System.out.println(dp);
        return res;
    }
}