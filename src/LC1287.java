class Solution {
    public int findSpecialInteger(int[] arr) {
        int times=1;
        int shouldTimes = arr.length/4;
        int last =arr[0];
        for (int i=1;i<arr.length;i++) {
            if(last==arr[i])
            {
                times++;
                if(times>shouldTimes)
                    return arr[i];
            }
            else{
                times=1;
                last=arr[i];
            }
        }
        return last;
    }
}