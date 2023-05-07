import java.util.*;

class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // 入度
        int[] inDegree = new int[nums.length + 1];
        // 建图
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] s : sequences) {
            for (int i = 0; i < s.length - 1; i++) {
                Set<Integer> set = graph.getOrDefault(s[i], new HashSet<>());
                if (set.add(s[i + 1])) inDegree[s[i + 1]]++;
                graph.put(s[i], set);
            }
        }
        // 找出第一层入度为0的
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) if (inDegree[i] == 0) q.offer(i);
        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) return false;
            if (q.peek() != nums[index++]) return false;
            Set<Integer> set = graph.getOrDefault(q.poll(), new HashSet<>());
            for (int i : set) if (--inDegree[i] == 0) q.offer(i);
        }
        return index == nums.length;
    }
}