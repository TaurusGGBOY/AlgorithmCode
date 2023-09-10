import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] p : prerequisites) {
            Set<Integer> set = map.getOrDefault(p[1], new HashSet<>());
            set.add(p[0]);
            map.put(p[1], set);
            inDegree[p[0]]++;
        }

        Queue<Integer> zero = new ArrayDeque<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                zero.offer(i);
            }
        }

        int index = 0;
        while (!zero.isEmpty()) {
            int poll = zero.poll();
            res[index++] = poll;

            Set<Integer> set = map.getOrDefault(poll, new HashSet<>());
            for (int next : set) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    zero.offer(next);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return res;
    }
}