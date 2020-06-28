// 失败
class Solution {
    public int numSubseq(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            int j = i;
            if(min+max>target)
                continue;
            int temp=0;
            for (; j < nums.length; j++) {
                if(min+nums[j]>target)
                    continue;

                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (min + max <= target) {
                    temp++;
                }
            }
            if (j == nums.length) {
                count += ((int) (Math.pow(2, temp-1))) % (1000000007);
            }
        }
        return count;

    }
}