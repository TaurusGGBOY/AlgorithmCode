class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(nums[i]+nums[j]!=target)
        {
            if(nums[i]+nums[j]<target)
                i++;
            if(nums[i]+nums[j]>target)
                j--;
        }LC208.java
        int[] temp = new int[2];
        temp[0]=nums[i];
        temp[1]=nums[j];
        return temp;
    }
}