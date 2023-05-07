import java.util.*;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        // [startnum, endnum]
        int start = nums[0];
        int last = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                start = nums[i];
                last = nums[i];
                count++;
                continue;
            }
            last = nums[i];
        }
        count++;
        return count;
    }
}