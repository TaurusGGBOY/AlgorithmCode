class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroPos] = nums[i];
                zeroPos++;
            }
        }
        for (int i = zeroPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}