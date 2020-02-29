class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0 ? 1 : 0;
        }
        int[] temp = new int[nums.length];
        for (int num : nums) {
            try {
                temp[num] = 1;
            } catch (Exception e) {

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] == 0)
                return i;
        }
        return nums.length;
    }
}