import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i]) ) return true;
            set.add(nums[i]);
            set.remove(nums[i - k]);
        }
        return false;
    }
}