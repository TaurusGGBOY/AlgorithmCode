import java.util.*;

class Solution {
    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        char[] chars = rings.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            Set<Character> set = map.getOrDefault(chars[i * 2 + 1], new HashSet<>());
            set.add(chars[i * 2]);
            map.put(chars[i * 2 + 1], set);
        }
        int res =0;
        for (Set<Character> value : map.values()) {
            res += value.size() == 3 ? 1 : 0;
        }
        return res;
    }
}