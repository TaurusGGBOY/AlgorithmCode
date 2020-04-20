import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int dominantIndex(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxNum = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                maxPos = i;
            }
        }
        int second = 0;
        for (int num : set) {
            if (second < num && num != maxNum) {
                second = num;
            }
        }
        return maxNum>=second*2?maxPos:-1;

    }
}