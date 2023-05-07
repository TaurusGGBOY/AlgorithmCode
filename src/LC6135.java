import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int longestCycle(int[] edges) {
        int[] vis = new int[edges.length + 7];
        int res = -1;
        for (int i = 0; i < edges.length; i++) {
            if (vis[i] == 1) continue;
            vis[i] = 1;

            Set<Integer> set = new HashSet<>();
            set.add(i);

            int next = edges[i], count = 1;
            while (next != -1) {
                if (vis[next] == 1) {
                    if (set.contains(next))  res = Math.max(count  - compute(edges, i, next), res);
                    break;
                }
                count++;

                vis[next] = 1;
                set.add(next);

                next = edges[next];
            }
        }
        return res;
    }

    int compute(int[] edges, int start, int in) {
        int res = 0;
        while (start != in) {
            start = edges[start];
            res++;
        }
        return res;
    }
}
