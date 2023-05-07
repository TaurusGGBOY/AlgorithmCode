import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] lens = new int[words.length];
        int[] times;
        int j=0;
        int temp=0;
        for(int i=0;i<words.length;i++)
        {
            times = new int[26];

            for(j=0;j<words[i].length();j++)
            {
                times[words[i].charAt(j)-'a']++;
            }

            for(j=0;j<26;j++)
            {
                if(times[j]!=0)
                {
                    lens[i]=times[j];
                   break;
                }
            }
        }
        Arrays.sort(lens);
        int[] results = new int[queries.length];
        int tempSum;
        for(int i=0;i<queries.length;i++)
        {
            tempSum=0;
            times = new int[26];

            for(j=0;j<queries[i].length();j++)
            {
                times[queries[i].charAt(j)-'a']++;
            }

            for(j=0;j<26;j++)
            {
                if(times[j]!=0)
                {
                    break;
                }
            }
            for(int k=0;k<lens.length;k++)
            {
                if(times[j]<lens[k])
                    tempSum++;
            }
            results[i] = tempSum;
        }
        return results;
    }
}