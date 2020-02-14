class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i+j!=target)
        {
            if(i+j<target)
                i++;
            if(i+j>target)
                j--;
        }
        int[] temp = new int[2];
        temp[0]=i;
        temp[1]=j;
        return temp;
    }
}