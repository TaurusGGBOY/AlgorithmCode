import java.util.Arrays;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0, j = (1 + nums.length) / 2; j < nums.length; j++) {
            if (nums[i] * 2 <= nums[j]) {
                count += 2;
                i++;
            }
        }
        return count;
    }
}