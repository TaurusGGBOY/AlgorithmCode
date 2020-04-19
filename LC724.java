class Solution {
    public int pivotIndex(int[] nums) {
        int sum =0;
        for(int num:nums)
        {
            sum+=num;
        }
        int nowSum =0;
        int leftSum=0;
        int rightSum=sum;
        for(int i=0;i<nums.length;i++)
        {
            if(leftSum==rightSum-nums[i])
                return i;
            leftSum+=nums[i];
            rightSum-=nums[i];
        }
        return -1;
    }
}