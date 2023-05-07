import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(entry->{
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        });
        return stringBuilder.toString();
    }
}