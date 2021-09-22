class Solution {
    public int findPeakElement(int[] nums) {
       int l = 0;
        int r = nums.length - 1;
        int m = (l + r) >> 2;
        while (l < r) {
            m = (l + r) >> 2;
            if (nums[m] > nums[m + 1]) {
                // m有可能是峰值？
                r = m;
            }else{
                // m不是峰值 m+1可能是
                l = m + 1;
            }
        }
        return l;
    }


}