import java.util.*;

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        if (nums.size() == 1) {
            return 1;
        }

        int l = 0;
        int r = nums.size() - 1;
        int ans = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int[] res = check(nums, k, m);
            if (res[0] == 1) {
                ans = res[1];
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println();
        return ans;
    }

    private int[] check(List<Integer> nums, int k, int m) {
        System.out.println("start check: " + nums.toString() + " m:" + m);

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Set<Integer>> treeMap = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            map.merge(nums.get(i), 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Set<Integer> set = treeMap.getOrDefault(entry.getValue(), new HashSet<>());
            set.add(entry.getKey());
            treeMap.put(entry.getValue(), set);
        }
        System.out.println("start treeMap:" + treeMap);
        System.out.println("start counter:" + map);

        int maxCount = treeMap.lastKey();
        if (maxCount + k >= m + 1) {
            System.out.println("here1");
            System.out.println(treeMap.lastKey() + " " + treeMap.lastEntry().getValue() + " m:" + m);
            System.out.println("counter:" + map.toString());
            System.out.println("treeMap:" + treeMap.toString());
            return new int[]{1, maxCount};
        }

        for (int i = m + 1; i < nums.size(); i++) {
            System.out.println("here3");
            int firstKey = nums.get(i - m - 1);
            int lastKey = nums.get(i);
            decrease(map, treeMap, firstKey);
            System.out.println("counter:" + map.toString());
            System.out.println("treeMap:" + treeMap.toString());
            increase(map, treeMap, lastKey);
            maxCount = treeMap.lastKey();
            if (maxCount + k >= m + 1) {
                System.out.println("here2");
                System.out.println(treeMap.lastKey() + " " + treeMap.lastEntry().getValue() + " m:" + m);
                System.out.println("counter:" + map.toString());
                System.out.println("treeMap:" + treeMap.toString());
                return new int[]{1, maxCount};
            }
        }
        return new int[]{0, 0};
    }

    private static void decrease(Map<Integer, Integer> map, TreeMap<Integer, Set<Integer>> treeMap, int firstKey) {
        int firstCount = map.get(firstKey);
        Set<Integer> firstSet = treeMap.getOrDefault(firstCount, new HashSet<>());
        firstSet.remove(firstKey);
        if (firstSet.isEmpty()) {
            treeMap.remove(firstCount);
        } else {
            treeMap.put(firstCount, firstSet);
        }


        Set<Integer> firstPreSet = treeMap.getOrDefault(firstCount - 1, new HashSet<>());
        firstPreSet.add(firstKey);
        treeMap.put(firstCount - 1, firstPreSet);

        map.put(firstKey, firstCount - 1);
    }

    private static void increase(Map<Integer, Integer> map, TreeMap<Integer, Set<Integer>> treeMap, int firstKey) {
        int firstCount = map.getOrDefault(firstKey, 0);
        Set<Integer> firstSet = treeMap.getOrDefault(firstCount, new HashSet<>());
        firstSet.remove(firstKey);
        if (firstSet.isEmpty()) {
            treeMap.remove(firstCount);
        } else {
            treeMap.put(firstCount, firstSet);
        }

        Set<Integer> firstPreSet = treeMap.getOrDefault(firstCount + 1, new HashSet<>());
        firstPreSet.add(firstKey);
        treeMap.put(firstCount + 1, firstPreSet);
        map.put(firstKey, firstCount + 1);
    }
}