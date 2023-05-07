import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int pos = 0;
        for (int i = 0; i <= max; i++) {
            while (pos < nums.length && nums[pos] < i) pos++;
            if (nums.length - pos == i) return i;
        }
        return -1;
    }
}