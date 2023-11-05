import java.util.*;

class Solution {
    long[][] score;
    Map<Integer, Set<Integer>> indices;

    boolean[] vis;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        indices = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            indices.put(i, new HashSet<>());
        }

        vis = new boolean[values.length];

        for (int i = 0; i < edges.length; i++) {
            indices.get(edges[i][0]).add(i);
            indices.get(edges[i][1]).add(i);
        }


        score = new long[values.length][2];


        dfs(edges, values, 0);
//        System.out.println(Arrays.deepToString(score));
        return score[0][0];
    }

    void dfs(int[][] edges, int[] values, int node) {
        // path1: remind root
        // path2: clear root but left and right child are valid
//        System.out.println("node:" + node);

        if (vis[node]) {
            return;
        }

        vis[node] = true;

        long sum1 = 0;
        long sum2 = 0;

        Set<Integer> set = indices.get(node);

        boolean foundOne = false;
        for (int i : set) {
            int child = -1;
            if (edges[i][0] == node) {
                child = edges[i][1];
            } else {
                child = edges[i][0];
            }

            if (vis[child]) {
                continue;
            }

            foundOne = true;

            dfs(edges, values, child);

            sum1 += score[child][0];
            sum2 += score[child][1];
        }

        if (!foundOne) {
            score[node][0] = 0;
            score[node][1] = values[node];
            return;
        }

        score[node][0] = Math.max(sum1 + values[node], sum2);
        score[node][1] = sum2 + values[node];
    }
}