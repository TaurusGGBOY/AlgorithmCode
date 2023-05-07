class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int right = -1;
        int max = Integer.MIN_VALUE;
        int left = -1;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }

            if (min < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}