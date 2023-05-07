import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        List<AbstractMap.SimpleEntry<String,Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            AbstractMap.SimpleEntry<String, Integer> simpleEntry = new AbstractMap.SimpleEntry<>(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            list.add(simpleEntry);
        }
        list.sort(new Comparator<AbstractMap.SimpleEntry<String, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<String, Integer> o1, AbstractMap.SimpleEntry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue()-o1.getValue();
            }
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}