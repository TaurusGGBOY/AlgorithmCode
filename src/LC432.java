import java.util.*;
import java.util.stream.*;

class AllOne {
    Map<String, Integer> counter;
    TreeMap<Integer, Set<String>> treeMap;

    public AllOne() {
        counter = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void inc(String key) {
        int cnt = counter.getOrDefault(key, 0);
        if (cnt != 0) {
            Set<String> set = treeMap.get(cnt);
            set.remove(key);
            if (set.isEmpty()) treeMap.remove(cnt);
            else treeMap.put(cnt, set);
        }
        counter.put(key, cnt + 1);
        Set<String> set = treeMap.getOrDefault(cnt + 1, new HashSet<>());
        set.add(key);
        treeMap.put(cnt + 1, set);
    }

    public void dec(String key) {
        int cnt = counter.get(key);
        Set<String> set = treeMap.get(cnt);
        set.remove(key);
        if (set.isEmpty()) treeMap.remove(cnt);
        else treeMap.put(cnt, set);
        counter.remove(key);
        if (cnt - 1 > 0) {
            counter.put(key, cnt - 1);
            Set<String> temp = treeMap.getOrDefault(cnt - 1, new HashSet<>());
            temp.add(key);
            treeMap.put(cnt - 1, temp);
        }
    }

    public String getMaxKey() {
        if (treeMap.isEmpty()) return "";
        Set<String> set = treeMap.lastEntry().getValue();
        for (String s : set) return s;
        return "";
    }

    public String getMinKey() {
        if (treeMap.isEmpty()) return "";
        Set<String> set = treeMap.firstEntry().getValue();
        for (String s : set) return s;
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */