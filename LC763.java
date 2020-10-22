import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char c : S.toCharArray()) {
            map.merge(c, 1, (oldval, newval) -> oldval + newval);
        }
        for (char c : S.toCharArray()) {
            stringBuilder.append(c);
            set.add(c);
            int count = map.get(c) - 1;
            map.put(c, count);
            if (count == 0) {
                set.remove(c);
            }
            if(set.size()==0)
            {
                res.add(stringBuilder.length());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        if (stringBuilder.length() > 0)
            res.add(stringBuilder.length());
        return res;
    }
}