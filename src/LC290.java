import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            String[] strs = str.split(" ");
            Map<Character,String> map = new HashMap<>();
            Map<String,Character> cMap = new HashMap<>();
            if(strs.length!=pattern.length())
                return false;
            for (int i = 0; i < strs.length; i++) {
                map.put(pattern.charAt(i),strs[i]);
                if(cMap.containsKey(strs[i])&&cMap.get(strs[i])!=pattern.charAt(i))
                    return false;
                else
                {
                    cMap.put(strs[i], pattern.charAt(i));
                }
            }
            for(int i =0;i<strs.length;i++)
            {
                stringBuilder.append(map.get(pattern.charAt(i)));
                stringBuilder.append(" ");
            }
        } catch (Exception e) {
            return false;
        }
        return stringBuilder.toString().trim().equals(str);
    }
}