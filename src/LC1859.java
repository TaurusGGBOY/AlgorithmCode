import java.util.HashMap;
import java.util.Map;

class Solution {
    public String sortSentence(String s) {
        String[] s1 = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (String s2 : s1) {
            map.put(s2.charAt(s2.length() - 1)-'0', s2.substring(0, s2.length() - 1));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= s1.length; i++) {
            stringBuilder.append(map.get(i));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}