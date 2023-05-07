import java.util.Arrays;

class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int leftMax = 0;
        int RightMax = 0;
        int leftMin = 0;
        int rightMin = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                leftMax = i+1;
                RightMax = nums.length - i;
            }
            if (min == nums[i]) {
                leftMin = i+1;
                rightMin = nums.length - i;
            }
        }

        int res = Integer.MAX_VALUE;
        res = Math.min(res, leftMax + rightMin);
        res = Math.min(res, RightMax + leftMin);
        res = Math.min(res, Math.max(leftMax, leftMin));
        res = Math.min(res, Math.max(RightMax, rightMin));
        return res;
    }
}