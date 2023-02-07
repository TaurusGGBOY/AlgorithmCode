import java.util.*;

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, String> maxId = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> viewMap = new HashMap<>();
        for (int i = 0; i < views.length; i++) {
            viewMap.put(creators[i] + "_" + ids[i], views[i]);
        }
        for (int i = 0; i < views.length; i++) {
            String c = creators[i];
            String id = ids[i];
            int view = views[i];

            if (!maxId.containsKey(c)) maxId.put(c, id);
            else {
                int maxView = viewMap.get(c + "_" + maxId.get(c));
                if (maxView < view) {
                    maxId.put(c, id);
                } else if (maxView == view && maxId.get(c).compareTo(id) > 0) {
                    maxId.put(c, id);
                }
            }
            count.put(c, count.getOrDefault(c, 0) + view);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() != max) continue;
            List<String> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(maxId.get(entry.getKey()));
            res.add(list);
        }
        return res;
    }
}