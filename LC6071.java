import java.util.*;

class Solution {
    int max;

    class Node {
        int parent;
        int index;
        char c;
        List<Integer> child;

        Node(int index, char c, int parent) {
            this.index = index;
            this.c = c;
            this.parent = parent;
            child = new ArrayList<>();
        }
    }

    Map<Integer, Node> map;

    int[] dp;

    public int longestPath(int[] parent, String s) {
        map = new HashMap<>();
        max = 1;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                if (!map.containsKey(parent[i]))
                    map.put(parent[i], new Node(parent[i], s.charAt(parent[i]), parent[parent[i]]));
                Node p = map.get(parent[i]);
                p.child.add(i);
                map.put(parent[i], p);
            }
            if (!map.containsKey(i)) map.put(i, new Node(i, s.charAt(i), parent[i]));
        }
        dp = new int[parent.length + 1];
        Arrays.fill(dp, -1);

        for (int i = parent.length - 1; i >= 0; i--) {
            dfs(i);
        }
        return max;
    }

    void dfs(int index) {
        if (dp[index] != -1) return;
        Node node = map.get(index);
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> -dp[o1] + dp[o2]);
        for (int i : node.child) {
            if (map.get(i).c != node.c) {
                dfs(i);
                bigHeap.offer(i);
            }
        }
        if(bigHeap.size() == 0) dp[index] = 1;
        if(bigHeap.size() >= 1){
            dp[index] = dp[bigHeap.peek()] + 1;
            int sum = 0;
            sum += dp[bigHeap.poll()];
            if (bigHeap.size() >= 1) {
                sum += dp[bigHeap.poll()];
            }
            max = Math.max(max, sum + 1);
        }
    }
}