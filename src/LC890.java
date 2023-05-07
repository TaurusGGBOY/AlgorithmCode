import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) res.add(word);
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        if (word.length() != pattern.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revertMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i)) && !map.values().contains(word.charAt(i))) {
                map.put(pattern.charAt(i), word.charAt(i));
                revertMap.put(word.charAt(i), pattern.charAt(i));
            }
            else if (map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)) != word.charAt(i) ) return false;
            else if (revertMap.containsKey(word.charAt(i)) && revertMap.get(word.charAt(i)) != pattern.charAt(i)  ) return false;
        }
        return true;
    }
}