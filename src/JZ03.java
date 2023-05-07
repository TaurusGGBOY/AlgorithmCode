import java.util.*;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)) return num;
            set.add(num);
        }
        return nums[0];
    }
}