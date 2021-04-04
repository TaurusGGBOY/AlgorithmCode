import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            map.put(log[0], set);
        }
        int[] res = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            res[entry.getValue().size()-1]++;
        }
        return res;
    }
}