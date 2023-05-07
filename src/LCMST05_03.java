class Solution {
    public int reverseBits(int num) {
        if(num==0)
            return 1;
        char[] carr = Integer.toBinaryString(num).toCharArray();
        int[] front = new int[carr.length+2];
        int[] right = new int[carr.length+2];
        int left =0;
        int max=0;
        for (int i = 1; i < carr.length+1; i++) {
            if(carr[i-1]=='1')
            {
                left++;
            }
            else
            {
                front[i]=left;
                right[i-left-1]=left;
                max = Math.max(front[i-left-1]+right[i-left-1]+1,max);
                left=0;
            }
        }
        int i =carr.length+1;
        front[i]=left;
        right[i-left-1]=left;
        max = Math.max(front[i-left-1]+right[i-left-1]+1,max);
        return max;
    }
}