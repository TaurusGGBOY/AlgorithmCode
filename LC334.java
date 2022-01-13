import java.util.Arrays;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // first 左边的最小值
        // second 满足条件的序列的第二个
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num > second) return true;
            else if(num > first) second = num;
            else first = num;
        }
        return false;
    }
}