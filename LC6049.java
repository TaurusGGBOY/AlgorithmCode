import java.util.*;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.clear();
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    count++;
                    if (count > k) break;
                    list.add(nums[j]);
                    set.add(new ArrayList<>(list));
                    continue;
                }
                list.add(nums[j]);
                set.add(new ArrayList<>(list));
            }
        }
        return set.size();
    }
}