class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Math.max(nums[0], 0);
        int max=nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (sum + nums[i] < 0) {
				sum=0;
				if(nums[i]>max)
					max = nums[i];
			}
			else
			{
				sum += nums[i];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
    }
}