import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int state = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                String value = map.getOrDefault(temp.toString(),"?");
                res.append(value);
                state = 0;
                temp.setLength(0);
                continue;
            }
            if (c=='(') {
                state=1;
                continue;
            }
            if (state == 1) {
                temp.append(c);
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}