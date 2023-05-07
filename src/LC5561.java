class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int[] res = new int[n+1];
        res[0]=0;
        res[1]=1;
        int max = 1;

        for (int i = 2; i < res.length; i++) {
            int half = i/2;
            if(i%2==0)
            {
                res[i]=res[half];
                max = Math.max(max, res[i]);
            }
            else
            {
                res[i]=res[half]+res[half+1];
                max = Math.max(max, res[i]);
            }
        }
        return max;
    }
}