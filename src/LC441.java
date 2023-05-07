class Solution {
    public int arrangeCoins(int n) {
        for(int i=0;i<=n;i++)
        {
            if(i*i+i<=2*n&&(i+2)*(i+1)>2*n)
                return i;
        }
        return n;
    }
}