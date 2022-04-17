import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Set<String> set = new HashSet<>();
        for (String s : banned) set.add(s);
        Map<String, Integer> map = new HashMap<>();
        String[] strs = paragraph.split("[\\s!?',;\\.]+");
        for (String str : strs) {
            if (!set.contains(str)) map.merge(str, 1, Integer::sum);
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }
}