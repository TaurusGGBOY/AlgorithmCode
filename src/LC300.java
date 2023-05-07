import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == list.get(list.size() - 1)) continue;
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                continue;
            }
            int index = Collections.binarySearch(list, nums[i]);
            if (index < 0) list.set(-index - 1, nums[i]);
        }
        return list.size();
    }
}