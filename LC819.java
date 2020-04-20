import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] strs = paragraph.toLowerCase().substring(0, paragraph.length()).split("[ !?',;.]");
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(String str:banned)
            set.add(str.trim());
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].isEmpty())
                continue;
            if (!set.contains(strs[i])) {
                map.merge(strs[i], 1, (oldval, newval) -> oldval + newval);
            }
        }
//        System.out.println(map.size());

        String res = "";
        int maxNum=0;
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            if(maxNum<entry.getValue())
            {
                maxNum = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

}