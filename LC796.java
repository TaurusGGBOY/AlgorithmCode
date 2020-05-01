class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length())
            return false;
        if(A.length()<=1)
            return true;
        StringBuilder stringBuilder = new StringBuilder(B);
        for(int i=0;i<B.length();i++)
        {
            char c = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(c);
            if(stringBuilder.toString().equals(A))
                return true;
        }
        return false;
    }
}