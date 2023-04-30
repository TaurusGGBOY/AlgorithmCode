import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    static int minCost;

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        List<int[]> list = Arrays.stream(specialRoads).filter(o1 -> {
            int dis = o1[3] - o1[1] + o1[2] - o1[0];
            return dis > o1[4];
        }).sorted((o1, o2) -> {
            return Math.abs(o1[0]-start[0]) + Math.abs(o1[1]-start[1]) - Math.abs(o2[0]-start[0]) - Math.abs(o2[1]-start[1]);
        }).collect(Collectors.toList());

        minCost = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);
        dfs(start, target, list, );
        return cost;

    }
}