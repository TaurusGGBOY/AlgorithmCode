
class Solution {
    public String sortString(String s) {
        int[] times = new int[26];
        for(int i=0;i<s.length();i++)
        {
            times[s.charAt(i)-'a']++;
        }
       int flag =0;
        StringBuilder stringBuilder = new StringBuilder();
        while (flag == 0) {
            flag=1;
            for(int i=0;i<26;i++)
            {
                if(times[i]!=0)
                {
                    times[i]--;
                    stringBuilder.append((char) ('a' + i));
                    flag=0;
                }

            }
            for(int i=25;i>=0;i--)
            {
                if(times[i]!=0)
                {
                    times[i]--;
                    stringBuilder.append((char) ('a' + i));
                    flag=0;
                }
            }
        }
        return stringBuilder.toString();
    }
}