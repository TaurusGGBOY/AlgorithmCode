class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r) / 2;
        while (l <= r) {
            if (m % 2 == 0 && m + 1 < nums.length && nums[m] == nums[m + 1]) l = m + 2;
            else if (m % 2 == 1 && m + 1 < nums.length && nums[m] == nums[m + 1]) r = m - 1;
            else if (m % 2 == 1 && m > 0 && nums[m] == nums[m - 1]) l = m + 1;
            else if (m % 2 == 0 && m > 0 && nums[m] == nums[m - 1]) r = m - 2;
            else return nums[m];
            m = (l + r) / 2;
        }
        return m;
    }

}