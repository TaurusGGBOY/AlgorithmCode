class Solution {
    int sum=0;
    int max=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        for(int num:nums)
        {
            sum+=num;
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;

        }
        return max;
    }
}