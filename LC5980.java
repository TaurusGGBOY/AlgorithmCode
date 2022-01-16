import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (char c : chars) {
            if (temp.length() == k) {
                list.add(temp.toString());
                temp.setLength(0);
            }
            temp.append(c);
        }
        int len = temp.length();
        for (int i = 0; i < k - len; i++) {
            temp.append(fill);
        }
        list.add(temp.toString());
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}