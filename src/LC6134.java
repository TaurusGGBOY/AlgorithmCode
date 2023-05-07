import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = new int[edges.length];
        int[] dis2 = new int[edges.length];
        Arrays.fill(dis1, Integer.MIN_VALUE);
        Arrays.fill(dis2, Integer.MIN_VALUE);
        int res = Integer.MAX_VALUE;
        dis1[node1] = 0;
        dis2[node2] = 0;
        compute(dis1, edges, node1);
        compute(dis2, edges, node2);
        int nodeNum = -1;
        for (int i = 0; i < dis1.length; i++) {
            if (dis1[i] == Integer.MIN_VALUE || dis2[i] == Integer.MIN_VALUE) continue;
            int max = Math.max(dis1[i], dis2[i]);
            if (max < res) {
                res = max;
                nodeNum = i;
            }
        }
        return nodeNum;
    }

    void compute(int[] dis, int[] edges, int node) {
        Set<Integer> set = new HashSet<>();
        set.add(node);
        int next = edges[node];
        int temp = 0;
        while (next != -1) {
            if (set.contains(next)) break;
            set.add(next);
            temp++;
            dis[next] = temp;
            next = edges[next];
        }
    }
}