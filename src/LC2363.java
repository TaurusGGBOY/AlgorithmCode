import java.util.*;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], item[1] += map.getOrDefault(item[0], 0));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        return res;
    }
}