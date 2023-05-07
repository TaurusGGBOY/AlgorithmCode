import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int dis = nums[k - 1] - nums[0];
        for (int i = 1; i < nums.length - k + 1; i++) dis = Math.min(nums[i + k - 1] - nums[i], dis);
        return dis;
    }
}