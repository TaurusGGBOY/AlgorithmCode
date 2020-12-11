class Solution {
    public String getSmallestString(int n, int k) {
        int remind =k-n;
        int remindChar = n;
        StringBuilder stringBuilder = new StringBuilder();
        while(remind>0)
        {
            if(remind<=25)
            {
                stringBuilder.append((char)('a'+remind));
                for(int i =0;i<remindChar-1;i++)
                {
                    stringBuilder.append('a');
                }
                break;
            }
            else
            {
                stringBuilder.append('z');
                remindChar--;
                remind-=25;
            }
        }
        return stringBuilder.reverse().toString();
    }
}