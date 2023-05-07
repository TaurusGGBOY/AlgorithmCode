import java.util.Arrays;

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        return Math.min(movesOdd(nums, true), movesOdd(temp, false));
    }

    int movesOdd(int[] nums, boolean odd) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (odd) {
                if (i % 2 == 1) continue;
            } else {
                if (i % 2 == 0) continue;
            }
            try {
                while (nums[i] >= nums[i - 1]) {
                    res++;
                    nums[i]--;
                }
            } catch (Exception e) {

            }
            try {
                while (nums[i] >= nums[i + 1]) {
                    res++;
                    nums[i]--;
                }
            } catch (Exception e) {

            }
        }
        return res;
    }
}