import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
            map.merge(num, 1, (oladval, newval) -> oladval + newval);
        }
        int count = 0;
        for (int num : set) {
            if (num + num == k) {
                count += map.get(num) / 2;
            } else {
                count += Math.min(map.getOrDefault(num,0), map.getOrDefault(k - num, 0));
                map.remove(num);
                map.remove(k - num);
            }
        }
        return count;
    }
}