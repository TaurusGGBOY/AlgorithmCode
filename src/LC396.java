class Solution {
    public int maxRotateFunction(int[] nums) {
       int sum = 0;
       int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            temp += i * nums[i];
        }
        int res = temp;
        for (int i = 1; i < nums.length; i++) {
            temp += sum;
            temp -= nums.length * nums[nums.length - i];
            res = Math.max(res, temp);
        }
        return res;
    }
}