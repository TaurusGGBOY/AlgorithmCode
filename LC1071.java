class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0,GCD(str1.length(), str2.length()));
        }
        return "";
    }
    public int GCD(int a,int b) {
        if(b==0)
            return a;
        else
            return GCD(b,a%b);
    }
}