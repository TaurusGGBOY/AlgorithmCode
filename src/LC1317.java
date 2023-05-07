class Solution {
    public int[] getNoZeroIntegers(int n) {

        for(int i=1;i<n;i++)
        {
            int temp = i;
            if(isRight(i,n-temp))
                return new int[]{temp, n - temp};
        }
        return new int[]{0, n};
    }
    private boolean isRight(int i,int num)
    {
        return !String.valueOf(i).contains("0")&&!String.valueOf(num).contains("0");
    }
}