class Solution {
    ;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] maxKSum = new int[nums.length];
        // 第一次循环 求出后k个的和
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums.length;
        }
        for (int i = 0; i < nums.length - k; i++) {
            maxKSum[i] = sum;
            // TODO if beyond range
            sum -= nums[i];
            sum += nums[i + k];
        }
        // 第二次循环 维护一个最大值 从后往前循环维护2K的值
        int max = maxKSum[nums.length - k];
        int[] maxTwoKSum = new int[nums.length];
        for (int i = nums.length - 2 * k; i > 0; i--) {
            max = Math.max(maxKSum[i + k], max);
            maxTwoKSum[i] = maxKSum[i] + max;
        }

        // 第三次循环 维护一个最大值 从后往前循环维护3K的值
        max = maxTwoKSum[nums.length - 2 * k];
        int[] maxThreeKSum = new int[nums.length];

        for (int i = nums.length - 3 * k; i > 0; i--) {
            max = Math.max(maxTwoKSum[i + k], max);
            maxThreeKSum[i] = maxKSum[i] + max;

        }
    }
}