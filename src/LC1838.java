import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int l = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            // 前面已经把所有的i之前的能变的都变成了i-1
            sum += (nums[i] - nums[i - 1]) * (i - l);
            while (sum > k) {
                sum -= nums[i] - nums[l];
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}