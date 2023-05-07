import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums[0]) {
            set.add(i);
        }
        for (int[] num : nums) {
            Set<Integer> temp = new HashSet<>();
            for (int i : num) {
                temp.add(i);
            }
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                if (!temp.contains(i)) {
                    iterator.remove();
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}