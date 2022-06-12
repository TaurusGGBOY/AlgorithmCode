import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res =0 ;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - nums[nums.length / 2]);
        }
        return res;
    }
}