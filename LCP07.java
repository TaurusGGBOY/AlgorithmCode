import java.util.*;

class Solution {
    int count;

    public int numWays(int n, int[][] relation, int k) {
        count = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Arrays.stream(relation).forEach(r -> {
            Set<Integer> set = map.getOrDefault(r[0], new HashSet<>());
            set.add(r[1]);
            map.put(r[0], set);
        });
        dfs(map, 0, 0, k, n);
        return count;
    }

    void dfs(Map<Integer, Set<Integer>> map, int index, int depth, int k, int n) {
        if (depth > k) {
            return;
        }
        if (depth == k && index == n - 1) {
            count++;
//            System.out.println(depth+" "+index);
            return;
        }
        Set<Integer> set = map.getOrDefault(index,new HashSet<>());

        for (int pos : set) {
            dfs(map, pos, depth + 1, k, n);
        }
    }
}