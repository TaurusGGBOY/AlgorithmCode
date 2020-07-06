import java.util.Arrays;

// 失败
class Solution {
    public int numSubseq(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            int j = i;
            if (min + max > target)
                continue;
            int temp = 0;
            for (; j < nums.length; j++) {
                if (min + nums[j] > target)
                    continue;
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }
            for (j = i; j < nums.length; j++) {
                if (min + nums[j] <= target) {
                    temp++;
                }
            }


            count = (((int) (Math.pow(2, temp - 1))) % (1000000007)+count)%1000000007;
        }
        return count;

    }
}