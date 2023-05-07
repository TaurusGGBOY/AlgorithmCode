import java.util.HashMap;
import java.util.Map;

class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i)==' ' || map.containsKey(key.charAt(i))) continue;
            map.put(key.charAt(i), (char) (count++ + 'a'));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i)==' ') stringBuilder.append(' ');
            else stringBuilder.append(map.get(message.charAt(i)));
        }
        return stringBuilder.toString();
    }
}