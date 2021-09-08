class Solution {
    int sum=0;
    int max=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        for(int num:nums)
        {
            total +=num;
            if(total >max)
                max= total;
            if(total <0)
                total =0;

        }
        return max;
    }
}