class Solution {
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int times=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==temp)
            {
                times++;
            }
            else
            {
                times--;
                if(times<0)
                {
                    times=1;
                    temp=nums[i];
                }
            }
        }
        return temp;
    }
}