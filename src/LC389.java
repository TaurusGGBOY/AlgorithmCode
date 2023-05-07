
    class Solution {
        public char findTheDifference(String s, String t) {
            int[] sarr = new int[26];
            for(int i=0;i< s.length();i++)
            {
                sarr[s.charAt(i)-'a']++;
            }
            int[] tarr = new int[26];
            for(int i=0;i< t.length();i++)
            {
                tarr[t.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                if(sarr[i]!=tarr[i])
                    return (char)('a'+i);
            }
            return 'a';
        }
    }