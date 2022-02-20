import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            // 判断单调的
            if (nums[0] <= nums[m]) {
                // 单调 且在本范围内 就二分 。等号上面特判了
                if (nums[0] <= target && target < nums[m]) r = m - 1;
                else l = m + 1; // 单调 且不再本范围内，就把锚点往后移动
            } else {
                if (nums[m] < target && target <= nums[nums.length - 1]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}