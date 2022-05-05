import java.util.*;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> list = new ArrayList<>();
        int n = 100;
        Collections.fill(list, new ArrayList<>());
        for (int[] r : rectangles) list.get(r[1]).add(r[0]);
        for (int i = 0; i <= n; i++) Collections.sort(list.get(i));

        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            for (int j = p[1]; j <= n; j++) {
                int index = Collections.binarySearch(list.get(j), p[0]);
                if (index < 0) index = -(index + 1);
                res[i] += list.get(j).size() - index;
            }
        }
        return res;
    }
}