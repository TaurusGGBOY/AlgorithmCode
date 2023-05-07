import java.util.Arrays;

class Solution {

    public int jump(int[] nums) {
        int step = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

}