class Solution {
    public int longestPalindrome(String s) {
        int[] alphas = new int[128];

        for(int i=0;i<s.length();i++)
            alphas[s.charAt(i)-'A']++;
        int flag=0;
        int count=0;
        for(int i=0;i<128;i++)
        {
            if(alphas[i]%2==1)
            {
                flag=1;
                count+=alphas[i]-1;
            }
            else{
                count+=alphas[i];
            }
        }
        count+=flag;
        return count;
    }
}