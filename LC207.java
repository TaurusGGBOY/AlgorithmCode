import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++)  inDegree.put(i, 0);

        for (int[] p : prerequisites) {
            Set<Integer> set = outDegree.getOrDefault(p[0], new HashSet<>());
            set.add(p[1]);
            outDegree.put(p[0], set);
            inDegree.merge(p[1], 1, Integer::sum);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = inDegree.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> e = iterator.next();
            if (e.getValue() == 0) {
                queue.offer(e.getKey());
                iterator.remove();
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<Integer> set = outDegree.getOrDefault(queue.poll(), new HashSet<>());
                for (int index : set) {
                    if (!inDegree.containsKey(index)) continue;
                    int degree = inDegree.get(index);
                    if (degree == 1) {
                        queue.offer(index);
                        inDegree.remove(index);
                    } else {
                        degree--;
                        inDegree.put(index, degree);
                    }
                }
            }
        }
        return inDegree.isEmpty();
    }
}