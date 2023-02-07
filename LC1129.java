import java.util.*;

class Solution {
    List<Integer> list;
    int[] res;
    Map<Integer, Set<Integer>> redMap;
    Map<Integer, Set<Integer>> blueMap;
    boolean[] redVis;
    boolean[] blueVis;
    Queue<Integer> q;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        list = new ArrayList<>();
        res = new int[n];
        redMap = new HashMap<>();
        blueMap = new HashMap<>();
        q = new ArrayDeque<>();

        Arrays.fill(res, Integer.MAX_VALUE);
        for (int[] redEdge : redEdges) {
            Set<Integer> set = redMap.getOrDefault(redEdge[0], new HashSet<>());
            set.add(redEdge[1]);
            redMap.put(redEdge[0], set);
        }

        for (int[] blueEdge : blueEdges) {
            Set<Integer> set = blueMap.getOrDefault(blueEdge[0], new HashSet<>());
            set.add(blueEdge[1]);
            blueMap.put(blueEdge[0], set);
        }

        redVis = new boolean[n];
        blueVis = new boolean[n];
        q.offer(0);
        bfs(false);

        Arrays.fill(redVis, false);
        Arrays.fill(blueVis, false);
        q.offer(0);
        bfs(true);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }

    void bfs(boolean isRed) {
        int depth = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int poll = q.poll();
                if (isRed && redVis[poll]) continue;
                if (!isRed && blueVis[poll]) continue;
                res[poll] = Math.min(res[poll], depth);
                if (isRed) redVis[poll] = true;
                else blueVis[poll] = true;

                if (isRed) q.addAll(redMap.getOrDefault(poll, new HashSet<>()));
                else q.addAll(blueMap.getOrDefault(poll, new HashSet<>()));
            }
            isRed = !isRed;
            depth++;
        }
    }
}