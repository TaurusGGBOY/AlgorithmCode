import java.util.*;

class Solution {
    List<Integer> path;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(graph, 0);
        return res;
    }

    private void dfs(int[][] graph, int depth) {
        path.add(depth);
        if (depth == graph.length - 1) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int i = 0; i < graph[depth].length; i++) {
            dfs(graph, graph[depth][i]);
        }
        path.remove(path.size() - 1);
    }
}