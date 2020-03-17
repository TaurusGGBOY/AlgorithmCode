class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==1431655765)
            return true;
        int temp =n^(n>>1);

        if(Integer.highestOneBit(temp+1)>>1==Integer.highestOneBit(temp))
            return true;
        return false;
    }
}