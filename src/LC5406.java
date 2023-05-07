import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int res=0;
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int[] edge : edges) {
            if (hasApple.get(edge[1])) {
                res += 2;
                hasApple.set(edge[0], true);
            }
        }
        return res;
    }


}