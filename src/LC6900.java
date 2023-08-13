import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                temp.add(nums[j]);
                if (temp.size() == set.size()) {
                    res++;
                }
            }
        }
        return res;
    }
}