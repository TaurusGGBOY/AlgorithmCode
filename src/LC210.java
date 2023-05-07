import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> next = new HashMap<>();
        Set<Integer> zeroSet = new HashSet<>();
        int[] inDegree = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < inDegree.length; i++) zeroSet.add(i);

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            zeroSet.remove(p[0]);

            Set<Integer> set = next.getOrDefault(p[1], new HashSet<>());
            set.add(p[0]);
            next.put(p[1], set);
        }

        while (!zeroSet.isEmpty()) {
            Iterator<Integer> iterator = zeroSet.iterator();
            int temp = iterator.next();
            iterator.remove();
            res.add(temp);

            Set<Integer> set = next.getOrDefault(temp, new HashSet<>());
            for (int i : set) if (--inDegree[i] == 0) zeroSet.add(i);
        }
        if(res.size()!=numCourses) return new int[0];

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;

    }
}
