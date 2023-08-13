class Solution {
    public int maxSum(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                int max1 = nums[i] % 10;
                int max2 = nums[j] % 10;
                while (num1 != 0) {
                    max1 = Math.max(max1, num1 % 10);
                    num1 = num1 / 10;
                }

                while (num2 != 0) {
                    max2 = Math.max(max2, num2 % 10);
                    num2 = num2 / 10;
                }

                if (max1 == max2) {
                    res = Math.max(nums[i] + nums[j], res);
                }
            }
        }
        return res;
    }
}