class Solution {
    public int minimumNumbers(int num, int k) {
        if(num ==0 ) return 0;
        for (int i = 1; i <= num; i++) {
            int val = num - i * k;
            if(val <0) return -1;
            if((num-i*k)%10==0) return i;
        }
        return -1;
    }
}