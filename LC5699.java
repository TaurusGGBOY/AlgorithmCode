// TODO：失败
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    final static int MOD = 1000000007;
    static int[][] distanceToLastNode;
    static Map<Integer, Map<Integer, Integer>> convex;

    public int countRestrictedPaths(int n, int[][] edges) {
        long res = 0;
        distanceToLastNode = new int[n+1][n+1];
        Arrays.fill(distanceToLastNode, Integer.MAX_VALUE);

        // 1. 建图
        convex = new HashMap<>();
        for (int[] edge : edges) {
            Map<Integer, Integer> map = convex.getOrDefault(edge[0], new HashMap<>());
            map.merge(edge[1], edge[2], (oldval, newval) -> oldval + newval);
            convex.put(edge[0], map);
            map = convex.getOrDefault(edge[1], new HashMap<>());
            map.merge(edge[0], edge[2], (oldval, newval) -> oldval + newval);
            convex.put(edge[1], map);
            distanceToLastNode[edge[0]][edge[1]] = edge[2];
            distanceToLastNode[edge[1]][edge[0]] = edge[2];
            distanceToLastNode[edge[0]][edge[0]] = 0;
            distanceToLastNode[edge[1]][edge[1]] = 0;
        }

        // 2. 从n开始dfs获取最短路径
        for (int i = 0; i < n; i++) {

            cacularDistanceToLastNode(n,n, i);
        }

        dfs(n, edges);
        return (int) (res % MOD);
    }

    private void dfs(int n, int[][] edges) {
    }

    private void cacularDistanceToLastNode(int n,int src, int dst) {
        if (distanceToLastNode[src][dst] == Integer.MAX_VALUE) {
            return;
        }
        if (distanceToLastNode[n][src] + distanceToLastNode[src][dst] < distanceToLastNode[n][dst]) {
            distanceToLastNode[n][dst] = distanceToLastNode[n][src] + distanceToLastNode[src][dst];

        }
    }

}