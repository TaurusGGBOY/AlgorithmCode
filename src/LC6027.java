class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            int l = i + 1;
            int r = l + 1;
            while (r < nums.length && nums[l] == nums[r]) r++;
            if (r >= nums.length) break;
            if (nums[i] < nums[l] && nums[r] < nums[l]) count++;
            else if (nums[i] > nums[l] && nums[r] > nums[l]) count++;
            i = r - 1;
        }
        return count;
    }
}