import java.util.*;

class Solution {
    class Node {
        Node left;
        Node right;
        int val;
    }

    Map<Integer, List<Integer>> map;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        map = new HashMap<>();
        int[] vis = new int[n];
        Set<Integer> restrict = new HashSet<>();
        for (int i : restricted) restrict.add(i);

        for (int[] edge : edges) {
            List<Integer> list1 = map.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            map.put(edge[0], list1);

            List<Integer> list2 = map.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }

        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int poll = q.poll();
                if (restrict.contains(poll) || vis[poll] == 1) continue;
                vis[poll] = 1;
                List<Integer> list = map.getOrDefault(poll, new ArrayList<>());
                for (int num : list) q.offer(num);
                res++;
            }
        }
        return res;
    }

}