class Solution {
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<S.length();i++)
        {
            if(stringBuilder.length()==0)
            {
                stringBuilder.append(S.charAt(i));
                continue;
            }
            if(stringBuilder.charAt(stringBuilder.length()-1)==S.charAt(i))
            {
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                continue;
            }
            stringBuilder.append(S.charAt(i));
        }
        return stringBuilder.toString();
    }
}