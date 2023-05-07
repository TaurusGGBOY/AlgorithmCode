import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        int l = 0, r = 1,count = 0;
        Set<Integer> set = new HashSet<>();
        if (k == 0) {
            Set<Integer> flag = new HashSet<>();

            for (int num : nums) {
                if (set.contains(num) && !flag.contains(num)) {
                    count++;
                    flag.add(num);
                }
                set.add(num);
            }
            return count;
        }
        for (int num : nums) set.add(num);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        while (r < list.size()) {
            while (l < r && list.get(r) - list.get(l) > k) l++;
            if (l < r && list.get(r) - list.get(l) == k) count++;
            r++;
        }
        return count;
    }
}