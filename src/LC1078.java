import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        int state = 0;
        List<String> list = new ArrayList<>();
        for (int i = 2; i < strs.length; i++) {
            if (strs[i - 2].equals(first) && strs[i - 1].equals(second)) {
                list.add(strs[i]);
            }
        }
        return list.toArray(new String[0]);
    }
}