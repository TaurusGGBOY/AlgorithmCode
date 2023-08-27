import java.util.*;

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word.charAt(0));
        }
        return s.contentEquals(stringBuilder);
    }
}