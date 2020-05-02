class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;
        int spos=0,tpos=0;
        spos=0;
        tpos=0;
        while(tpos<t.length()&&spos<s.length())
        {
            while(s.charAt(spos)!=t.charAt(tpos))
            {
                tpos++;
                if(tpos>=t.length())
                    break;
            }
            if(tpos>=t.length())
                break;
            spos++;
            tpos++;
        }
        return spos == s.length();
    }
}