import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    static int maxSize;
    public int maxUniqueSplit(String s) {
        maxSize=1;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            list.addLast(s.substring(0,i));
            dfs(list, i,s);
        }
        return maxSize;
    }

    public int dfs(LinkedList<String> list, int pos,String s)
    {
        if(pos>=s.length())
        {
            maxSize = Math.max(maxSize, list.size());
            return 0;
        }
        for(int i=pos+1;i<=s.length();i++)
        {
            String temp = s.substring(pos,i);
            if(list.contains(temp))
                continue;
            list.addLast(temp);
            dfs(list, i,s);
            list.removeLast();
        }
        return 0;
    }


}