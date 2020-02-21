class Solution {
    public int[] sumZero(int n) {
        int[] a = new int[n];
        for(int i=0;i<n-1;i++)
        {
            a[i]=i;
        }
        a[n-1]=(n-1)*(2-n)/2;
        return a;
    }
}