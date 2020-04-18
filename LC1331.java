import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        Vector<Integer> vector = new Vector<>();
        for (int num : arr) {
            if (!set.contains(num)) {
                vector.add(num);
                set.add(num);
            }
        }
        vector.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < vector.size(); i++) {
            map.put(vector.get(i), i + 1);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}