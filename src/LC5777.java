import java.util.*;

class Solution {
    public int reductionOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        list.sort(null);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        int count = 0;
        for (int num : nums) {
            count += map.get(num);
        }
        return count;
    }
}