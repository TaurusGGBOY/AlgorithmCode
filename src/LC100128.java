import java.util.*;

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for (List<String> list : access_times) {
            String name = list.get(0);
            String time = list.get(1);

            int min = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(2, 4));
            map.computeIfAbsent(name, key -> new ArrayList<>()).add(min);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() < 3) {
                continue;
            }

            Collections.sort(value);

            for (int i = 0; i < value.size() - 2; i++) {
                if (value.get(i + 2) - value.get(i) < 60) {
                    res.add(entry.getKey());
                    break;
                }

            }
        }

        return res;
    }
}