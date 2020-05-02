class Solution {
    int count =0;

    public int lengthOfLongestSubstring(String s) {
        char[] sca = s.toCharArray();
        int len = s.length();
        int[] alphaArray = new int[130];
        int maxCount=0;
        for(int j=0;j<130;j++)
        {
            alphaArray[j]=-1;
        }
        for(int i=0;i <len;i++)
        {
            if(alphaArray[sca[i]-0]!=-1)
            {
                for(int j=0;j<130;j++)
                {
                    if(alphaArray[j]!=-1&&alphaArray[j]<alphaArray[sca[i]-0])
                    {
                        alphaArray[j]=-1;
                        count--;
                    }
                }
            }
            else
            {
                count++;
                if(count > maxCount)
                    maxCount = count;
            }
            alphaArray[sca[i]-0]=i;

            //System.out.print(count);
            //System.out.print(sca[i]);
            //System.out.println(alphaArray[sca[i]-0]);
        }
        return maxCount;
    }
}