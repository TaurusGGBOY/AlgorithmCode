import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.merge(num, 1, (prev, newv) -> prev + newv);
        Set<Integer> set = new HashSet<>();
        set.addAll(map.values());
        return set.size() == map.size();
    }
}