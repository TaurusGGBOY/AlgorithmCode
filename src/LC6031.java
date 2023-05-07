import java.util.*;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(0, i - k); j < Math.min(nums.length, i + k + 1); j++) {
                    res.add(j);
                }
            }
        }
        List<Integer> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }
}