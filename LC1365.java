class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] times = new int[101];
        int[] lower = new int[101];
        int[] returnList = new int[nums.length];

        for(int num:nums)
            times[num]++;
        for(int i=1;i<101;i++)
        {
            lower[i]=lower[i-1]+times[i-1];
        }
        for(int j=0;j<nums.length;j++)
        {
            returnList[j]=lower[nums[j]];
        }
        return returnList;
    }
}