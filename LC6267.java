import java.util.*;

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        // 偶数度集合
        List<Integer> evenList = new ArrayList<>();
        for (List<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            Set<Integer> set1 = edgeMap.getOrDefault(x, new HashSet<>());
            set1.add(y);
            edgeMap.put(x, set1);
            Set<Integer> set2 = edgeMap.getOrDefault(y, new HashSet<>());
            set2.add(x);
            edgeMap.put(y, set2);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : edgeMap.entrySet()) {
            if (entry.getValue().size() % 2 == 1) evenList.add(entry.getKey());
        }

        if (evenList.size() > 4) return false;
        System.out.println();
        System.out.println(evenList);
        System.out.println(edgeMap);
        return dfs(evenList, 0, edgeMap, evenList.size());
    }

    boolean dfs(List<Integer> evenList, int index, Map<Integer, Set<Integer>> edgeMap, int evenNum) {
        System.out.println(index + " " + evenNum);
        if (evenNum == 0) return true;
        if (evenNum < 0) return false;
        if (index >= evenList.size()) {
            return false;
        }
        int startPos = evenList.get(index);
        Set<Integer> set = edgeMap.get(startPos);

        for (Map.Entry<Integer, Set<Integer>> entry : edgeMap.entrySet()) {
            System.out.println(entry.getKey() +" entry ");
            if (entry.getKey() == startPos) continue;
            if (entry.getValue().contains(startPos)) continue;
            entry.getValue().add(startPos);
            set.add(entry.getKey());

            if (entry.getValue().size() % 2 == 0) evenNum--;
            if (set.size() % 2 == 0) evenNum--;

            if (dfs(evenList, index + 1, edgeMap, evenNum)) return true;

            if (entry.getValue().size() % 2 == 0) evenNum++;
            if (set.size() % 2 == 0) evenNum++;

            entry.getValue().remove(startPos);
            set.remove(entry.getKey());
        }
        return false;
    }
}