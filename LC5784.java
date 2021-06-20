import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                map.merge(aChar, 1, (oldval, newval) -> oldval + newval);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}