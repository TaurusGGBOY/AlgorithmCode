import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<Integer>());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                res.add(list);
                map.remove(groupSizes[i]);
                continue;
            }
            map.put(groupSizes[i], list);
        }
        return res;
    }
}