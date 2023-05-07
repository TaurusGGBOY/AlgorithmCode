import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r) / 2;
        while (l < r) {
            if (nums[m] < target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return nums[l] == target ? l : -1;
    }
} 