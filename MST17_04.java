class Solution {
    public int missingNumber(int[] nums) {
        int num1 = nums.length;
        for (int i =0;i<nums.length;i++) {
            num1^=i^nums[i];
        }
        return num1;
    }
}