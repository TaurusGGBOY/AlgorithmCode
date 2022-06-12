import java.util.*;

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int l = 0, r=0;
        int res = Math.abs(list1.get(0) - list2.get(0));
        while (l < list1.size() && r < list2.size()) {
            res = Math.min(res, Math.abs(list1.get(l) - list2.get(r)));
            if (list1.get(l) < list2.get(r)) {
                l++;
            }else{
                r++;
            }
        }
        return res;
    }
}
