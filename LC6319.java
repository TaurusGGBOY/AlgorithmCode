class Solution {
    public int[] evenOddBit(int n) {
        boolean odd = false;
        int[] res = new int[2];
        while(n != 0){
            odd = !odd;
            if((1 & n)==0){
                n >>= 1;
                continue;
            }
            if(odd){
                res[0]++;
            }else{
                res[1]++;
            }
            n >>= 1;
        }
        return res;
    }
}