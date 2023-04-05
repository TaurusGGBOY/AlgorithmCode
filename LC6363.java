import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                List<Integer> list = res.size() <= i ? new ArrayList<>() : res.get(i);
                list.add(key);
                if (res.size() <= i) {
                    res.add(list);
                } else {
                    res.set(i, list);
                }
            }
        }
        return res;
    }
}