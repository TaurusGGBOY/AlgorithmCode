class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minVal=nums[0];
        for (int num:nums)
        {
            sum+=num;
            minVal = Math.min(sum, minVal);
        }
        return minVal>=0?1:-minVal+1;
    }
}