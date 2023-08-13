import java.util.*;
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (stringBuilder.length() == 0) {
                        continue;
                    }
                    res.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                } else {
                    stringBuilder.append(word.charAt(i));
                }
            }
            if (stringBuilder.length() != 0) {
                res.add(stringBuilder.toString());
            }
        }

        return res;
    }
}