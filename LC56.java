import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] - o2[0] == 0) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int l = intervals[0][0];
        int r = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > r) {
                res.add(new int[]{l, r});
                l = interval[0];
                r = Math.max(interval[1], r);
                continue;
            }
            r = Math.max(interval[1], r);
        }
        res.add(new int[]{l, r});
        int[][] ans = new int[res.size()][2];
        return res.toArray(ans);
    }
}