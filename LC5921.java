import java.beans.Visibility;
import java.util.*;

class Solution {
    Map<Integer, Map<Integer, Integer>> map;
    int max;
    int[] shortestTime;
    boolean[] visited;
    int[] values_;
    int[] passed;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        map = new HashMap<>();
        max = values[0];
        values_ = values;
        shortestTime = new int[values.length];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        visited = new boolean[values.length];
        passed = new int[values.length];

        dealEdges(edges);
//        System.out.println(map.toString());

        if (!map.containsKey(0)) {
            return values[0];
        }
        visited[0] = true;
        dfsTime(0, 0);
        visited[0] = false;
//        System.out.println(Arrays.toString(shortestTime));

        passed[0] = 1;
        for (int node : this.map.get(0).keySet()) {
            passed[node]++;
            dfs(node, values[0] + values[node], maxTime - map.get(0).get(node));
            passed[node]--;
        }
        return max;
    }

    void dealEdges(int[][] edges) {
        for (int[] edge : edges) {
            Map<Integer, Integer> map1 = map.getOrDefault(edge[0], new HashMap<>());
            map1.put(edge[1], edge[2]);
            map.put(edge[0], map1);
            Map<Integer, Integer> map2 = map.getOrDefault(edge[1], new HashMap<>());
            map2.put(edge[0], edge[2]);
            map.put(edge[1], map2);
        }
    }

    void dfsTime(int pos, int time) {
        shortestTime[pos] = time;
        for (int node : map.get(pos).keySet()) {
            if (!visited[node]) {
                int nextTime = time + map.get(pos).get(node);
                if (nextTime >= shortestTime[node]) {
                    continue;
                }
                visited[node] = true;
                dfsTime(node, nextTime);
                visited[node] = false;
            }
        }
    }

    void dfs(int pos, int value, int remindTime) {
        if (remindTime < shortestTime[pos]) {
            return;
        }
        if (pos == 0) {
            max = Math.max(max, getValue());
        }
        for (int node : map.get(pos).keySet()) {
            passed[node]++;
            dfs(node, value + values_[node], remindTime - map.get(pos).get(node));
            passed[node]--;
        }

    }

    int getValue(){
        int sum = 0;
        for (int i = 0; i < passed.length; i++) {
            if (passed[i] > 0) {
                sum += values_[i];
            }
        }
        return sum;
    }
}