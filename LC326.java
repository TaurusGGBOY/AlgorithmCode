class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1)
            return false;
        int res = (int)(Math.log(n) / Math.log(3)+0.1f);
//        System.out.println(Math.log(n) / Math.log(3));
//        System.out.println(res);
        return n==(int)Math.pow(3,res);
    }
}