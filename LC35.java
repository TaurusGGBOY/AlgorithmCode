import java.util.Arrays;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int m = (i + j) / 2;
        while (i < j) {
            m = (i + j) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] > target)
                j = m - 1;
            else
                i = m + 1;
        }
        if (nums[i] == target)
            return i;
        if (nums[i] > target)
            return i;
        else
            return i + 1;


    }
}