class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0)
            return 0;
        int temp = m;
        for(int i =m+1;i<=n;i++)
        {
            temp=temp&i;
        }
        return temp;
    }
}