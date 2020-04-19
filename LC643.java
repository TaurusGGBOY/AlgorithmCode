class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double maxSum=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        maxSum=sum;
        for(int i=k;i<nums.length;i++)
        {
            sum-=nums[i-k];
            sum+=nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return (maxSum*1.0f)/(k*1.0f);
    }
}