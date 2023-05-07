class Solution {
    public boolean isPowerOfFour(int num) {
        if(num==0)
            return false;
        if(num==1)
            return true;
        int temp = (int) (Math.log(num)/Math.log(4));
        return (int)Math.pow(4, temp) == num;
    }
}