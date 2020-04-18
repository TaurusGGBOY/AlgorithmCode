class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        if(A.equals(B))
        {
            int[] alpha = new int[26];
            for(int i=0;i<A.length();i++)
            {

                if(++alpha[A.charAt(i)-'a']>=2)
                {
                    return true;
                }
            }
        }
        int left=0;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)!=B.charAt(i))
            {
                left=i;
                break;
            }
        }
        int right=A.length()-1;
        for(int i=A.length()-1;i>=0;i--)
        {
            if(A.charAt(i)!=B.charAt(i))
            {
                right=i;
                break;
            }
        }
        if(left>=right)
            return false;
        char temp = A.charAt(left);
        StringBuilder stringBuilder = new StringBuilder(A);
        stringBuilder.setCharAt(left,stringBuilder.charAt(right));
        stringBuilder.setCharAt(right,temp);
        return stringBuilder.toString().equals(B);

    }
}