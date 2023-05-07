class Solution {
    public String[] permutation(String S) {
        int len=1;
        for(int i =1;i<=S.length();i++)
        {
            len *= i;
        }
        String[] strings = new String[len];
        
    }
}