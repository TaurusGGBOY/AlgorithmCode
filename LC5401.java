class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i =0;
        for(i =0;i<nums.length;i++)
        {
            if(nums[i]!=0)
                break;
        }
        int lastPos = i;
        for(i=i+1;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                if(i-lastPos-1<k)
                {
                    return false;
                }
                lastPos=i;
            }
        }
        return true;
    }
}