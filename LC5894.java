import java.util.*;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (int i : nums3) {
            set3.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : set1) {
            map.merge(i, 1, Integer::sum);
        }
        for (Integer i : set2) {
            map.merge(i, 1, Integer::sum);
        }
        for (Integer i : set3) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}