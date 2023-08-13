import java.util.*;

class Solution {

    int[] parents;

    public int countCompleteComponents(int n, int[][] edges) {
        parents = new int[n];
        for (int i = 0; i < parents.length; i++) parents[i] = i;

        for (int[] e : edges) {
            if (e[0] > e[1]) {
                int temp = e[1];
                e[1] = e[0];
                e[0] = temp;
            }
            merge(e[1], e[0]);
        }


        int[] counter = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int parent = find(e[0]);
            counter[parent]++;
            Set<Integer> set = map.getOrDefault(parent, new HashSet<>());
            set.add(e[0]);
            set.add(e[1]);
            map.put(parent, set);
        }


        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] != i) continue;
            int size = map.containsKey(i) ? map.get(i).size() : 0;
            if (counter[i] * 2 == size * (size - 1)) res++;
        }
        return res;
    }

    int find(int index) {
        if (index == parents[index]) return index;
        return find(parents[index]);
    }

    void merge(int index, int parent) {
        parents[find(index)] = find(parent);
    }
}