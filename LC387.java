import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int firstUniqChar(String s) {
        char[] cstr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int[] total = new int[26];
        for (char c : cstr) {
            total[c-'a']++;
        }
        for(int i=0;i<26;i++)
            if(total[i]>1)
                set.add((char) (i + 'a'));
        for (int i = 0; i < cstr.length; i++)
            if (!set.contains(cstr[i]))
                return i;
        return -1;
    }
}