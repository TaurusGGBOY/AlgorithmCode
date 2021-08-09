import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            for (int left = 0, right = i - 1; left < right; ) {
                if (nums[left] + nums[right] <= nums[i]) {
                    left++;
                } else {
                    count += right - left;
                    right--;
                }
            }
        }
        return count;
    }
}