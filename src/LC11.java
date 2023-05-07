class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = Math.min(height[0],height[len-1])*(len-1);
        int i=0;
        int j=height.length-1;
        int area;
        int left;
        int right;
        while(i<j)
        {
            left=height[i];
            right=height[j];
            maxArea=Math.max(maxArea,Math.min(left,right)*(j-i));
            if(left>right)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return maxArea;
    }
}